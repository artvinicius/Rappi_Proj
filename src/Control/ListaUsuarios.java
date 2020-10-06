package Control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Usuario;

public class ListaUsuarios {
	Scanner entrada = new Scanner(System.in);

	List<Usuario> usuarios = new ArrayList<Usuario>();

	public void salvarCadastro(Usuario usuario) {

		usuarios.add(usuario);
	}

	public Boolean buscarCadastro(String acesso) {

		for (Usuario usuario2 : usuarios) {

			if (usuario2.getNome().equals(acesso) || usuario2.getCodIdentificador().equals(acesso)) {

				return true;
			}
		}
		return false;
	}

	public void adicionarUsuario() {

		ListaUsuarios listaUsuarios = new ListaUsuarios();
		Usuario usuario = new Usuario();
		System.out.println("\nDigite seu nome:");
		usuario.setNome(entrada.next());
		System.out.println("Digite seu codigo de identifica��o:");
		usuario.setCodIdentificador(entrada.next());

		System.out.println("\nUsu�rio cadastrado com sucesso!");
		System.out.println(usuario.toString());
		listaUsuarios.salvarCadastro(usuario);

	}
}
