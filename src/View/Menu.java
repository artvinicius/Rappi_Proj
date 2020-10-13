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
	static Usuario user1 = new Usuario("Arthur", "1010", "DESLOGADO");
	static int tipo, codigo;
	static ListaUsuarios listaUsuarios = new ListaUsuarios();
	static Compras compras = new Compras();

	static Facade fc = new Facade(pontos, user1, listaUsuarios);

	public void menu() throws IOException, ClassNotFoundException {

		int opcao;
		boolean resultado = false;

		while (!resultado) {

			System.out.println("||------------SEJA BEM-VINDO------------||");
			System.out.println("||  [1] - Criar usuario                 ||");
			System.out.println("||  [2] - Fazer Login                   ||");
			System.out.println("||  [0] - Encerrar Sessao               ||");
			System.out.println("||--------------------------------------||");
			System.out.println("");
			System.out.print("Digite uma opcao: ");
			opcao = entrada.nextInt();

			boolean validacao = true;

			if (validacao) {

				if (opcao >= 0 && opcao <= 2) {
					opcoesMenu(opcao);
					resultado = true;
				} else {
					System.out.println("ATENCAO!!! Opcao Invalida!");
				}
			}
		}
	}

	public void opcoesMenu(int opcao) throws IOException, ClassNotFoundException {

		switch (opcao) {
		case 1:
			addUserPredefinido();
			break;
		case 2:
			validarUser();
			break;
		case 0:
			sairDoSistema();
			break;
		default:
			break;
		}
	}

	// Validacao do state
	public void validarUser() throws FileNotFoundException, ClassNotFoundException, IOException {
		SituacaoUsuarioState su = new SituacaoUsuario();
		if(user1.getNome().equals("Arthur")) {
			su.clienteLogado(user1);
			System.out.println("");
			menuUsuario();
			
		}
	}
	

	public void addUserPredefinido() throws IOException, ClassNotFoundException {
		System.out.println(user1.toString());
		System.out.println("");
		System.out.println("Usuario predefinido criado!!");
		System.out.println("");
		System.out.println("Voltando para o menu principal");
		System.out.println("");
		menu();
	}

	public static void menuUsuario() throws FileNotFoundException, ClassNotFoundException, IOException {

		int value;
		boolean resultado = false;

		while (!resultado) {
			System.out.println("||------------ MENU ----------------||");
			System.out.println("|| [1] - Realizar Compra            ||");
			System.out.println("|| [2] - Consultar Pontuacao        ||");
			System.out.println("|| [3] - Exibir historico           ||");
			System.out.println("|| [0] - Encerrar Sessao            ||");
			System.out.println("||----------------------------------||");
			System.out.print("Digite uma opcao: ");
			value = entrada.nextInt();

			switch (value) {
			case 1:
				fazerPedido();
				break;
			case 2:
				double somaPontuacao = user1.totalPontos();
				// System.out.println(somaPontuacao);
				compras.classificacao(somaPontuacao);
				compras.beneficios(somaPontuacao);
				menuUsuario();
				break;
			case 3:
				historicoCompras();
				break;
			case 0:
				sairDoSistema();
				break;
			default:
				break;
			}
		}
	}

	public static double fazerPedido() {

//		codigo;

		int quant;

		System.out.println("");

		System.out.println("||=================== CARDAPIO ===================");

		Cardapio c = new Cardapio();

		for (Produtos cardapio : c.produto) {

			System.out.println("|| " + cardapio.toString());

		}
		System.out.println("||================================================");

		System.out.print("\nInsira o codigo do produto: ");
		codigo = entrada.nextInt();

		System.out.print("Quantidade: ");
		quant = entrada.nextInt();

		double valorTotal = c.valorProduto(codigo) * quant;

		System.out.println("Valor Total R$ " + valorTotal);

		int tipo = pagamento();
		double pontos = pontuacao(tipo, valorTotal);

		user1.getPontos().add(pontos);

		return pontos;

	}

	public static int pagamento() {

		TipoPagamento pagamento = new TipoPagamento();

		System.out.println("Escolha a forma de pagamento: ");
		System.out.println("  1- Cartao\n  2- Prime\n  3- RappiPay\n  4- QRCode");
		System.out.print("Insira aqui: ");

		tipo = entrada.nextInt();
		System.out.println("Forma de Pagamento: " + pagamento.tipo(tipo));

		return tipo;

	}

	private static void sairDoSistema() {
		SituacaoUsuarioState su = new SituacaoUsuario();
		if(user1.getNome().equals("Arthur")) {
			su.clienteDeslogado(user1);
			System.out.println("Sistema Encerrado!");
			System.exit(0);
		}
	}

	public static double pontuacao(int forma, double valor) {

		return pontos.pontos(forma, valor);

	}

	public static  void historicoCompras() {
		
		Cardapio c = new Cardapio();

		System.out.println("Usuario:" + user1.getNome() + " Identificacao:" + user1.getCodIdentificador() 
		+ "\nPontuacao: " + user1.getPontos() + "\nPedido: " + codigo +  "" + "\nForma do Pagamento: " + tipo);

	}

}
