package View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

import Control.Compras;
import Control.Facade;
import Control.ListaUsuarios;
import Model.Cardapio;
import Model.Pontuacao;
import Model.Produtos;
import Model.SituacaoUsuario;
import Model.SituacaoUsuarioState;
import Model.TipoPagamento;
import Model.Usuario;

public class Menu {

	static Scanner entrada = new Scanner(System.in);

	static Pontuacao pontos = new Pontuacao();
	static Usuario usuario = new Usuario();
	static ListaUsuarios listaUsuarios = new ListaUsuarios();
	static Compras compras = new Compras();

	static Facade fc = new Facade(pontos, usuario, listaUsuarios);

	public void menu() throws IOException, ClassNotFoundException {

		int opcao;
		boolean resultado = false;

		while (!resultado) {

			System.out.println("------------SEJA BEM-VINDO------------");
			System.out.println("\nSelecione um opção:");
			System.out.println("\n  1- Fazer Login\n  0- Encerrar Sessão");
			System.out.print("Digite uma opção: ");
			opcao = entrada.nextInt();

			boolean validacao = true;

			if (validacao) {

				if (opcao >= 0 && opcao <= 1) {
					opcoesMenu(opcao);
					resultado = true;
				} else {
					System.out.println("ATENÇÃO!!! Opção Inválida!");
				}
			}
		}
	}

	public void opcoesMenu(int opcao) throws IOException, ClassNotFoundException {

		switch (opcao) {
		case 1:
			cadastrar();
			menuUsuario();
			break;
		case 0:
			sairDoSistema();
			break;
		default:
			break;
		}
	}

	public static Usuario cadastrar() throws FileNotFoundException, IOException, ClassNotFoundException {

		SituacaoUsuarioState su = new SituacaoUsuario();
		listaUsuarios.adicionarUsuario();

		// Padrão State
		su.clienteValidado(usuario);

		System.out.println(usuario.getNome());
		return usuario;

	}

	public static void logadoStatus() {

	}

	public static void menuUsuario() throws FileNotFoundException, ClassNotFoundException, IOException {

		Usuario user = new Usuario();

		int value;
		boolean resultado = false;

		while (!resultado) {
			System.out.println("------------------------ MENU ------------------------");
			System.out.println("\n1- Realizar Compra\n2- Consultar Pontuação\n3- Exibir histórico\n0- Encerrar Sessão");
			System.out.print("Digite uma opção: ");
			value = entrada.nextInt();

			switch (value) {
			case 1:
				fazerPedido();
				break;

			case 2:
				double somaPontuacao = usuario.totalPontos();
				// System.out.println(somaPontuacao);
				compras.classificacao(somaPontuacao);
				compras.beneficios(somaPontuacao);
				menuUsuario();
//			case 3:
//				historicoCompras();

			case 0:
				sairDoSistema();
			default:
				break;
			}
		}
	}

	public static double fazerPedido() {

		int codigo;

		int quant;

		System.out.println("");

		System.out.println("||=================== CARDÁPIO ===================");

		Cardapio c = new Cardapio();

		for (Produtos cardapio : c.produto) {

			System.out.println("|| " + cardapio.toString());

		}
		System.out.println("||================================================");

		System.out.print("\nInsira o código do produto: ");
		codigo = entrada.nextInt();

		System.out.print("Quantidade: ");
		quant = entrada.nextInt();

		double valorTotal = c.valorProduto(codigo) * quant;

		System.out.println("Valor Total R$ " + valorTotal);

		int tipo = pagamento();
		double pontos = pontuacao(tipo, valorTotal);

		usuario.getPontos().add(pontos);

		return pontos;

	}

	public static int pagamento() {

		TipoPagamento pagamento = new TipoPagamento();

		System.out.println("Escolha a forma de pagamento: ");
		System.out.println("  1- Cartão\n  2- Prime\n  3- RappiPay\n  4- QRCode");
		System.out.print("Insira aqui: ");

		int tipo = entrada.nextInt();
		System.out.println("Forma de Pagamento: " + pagamento.tipo(tipo));

		return tipo;

	}

	private static void sairDoSistema() {
		System.out.println("Sistema Encerrado!");
		System.exit(0);
	}

	public static double pontuacao(int forma, double valor) {

		return pontos.pontos(forma, valor);

	}

//
//	public static Usuario historicoCompras() {
//
//		System.out.println("Usuário:" + usuario.getNome() + "Identificação:" + usuario.getCodIdentificador() 
//		+ "\nPontuação: " + usuario.getPontuacao() + "\nPedido: " + "" + "\nForma do Pagamento: " + pagamento());
//		
//		return historicoCompras();
//	}

}
