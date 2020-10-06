package Control;

import Model.Pontuacao;
import Model.Usuario;

public class Facade {

	@SuppressWarnings("unused")
	private Pontuacao pontos;
	private Usuario usuario;
	@SuppressWarnings("unused")
	private ListaUsuarios listaUsuarios;

	public Facade(Pontuacao pontos, Usuario usuario, ListaUsuarios listaUsuarios) {
		this.pontos = pontos;
		this.usuario = usuario;
		this.listaUsuarios = listaUsuarios;
	}

	@SuppressWarnings("static-access")
	public void menu() {

		@SuppressWarnings("unused")
		Pontuacao pontos = new Pontuacao();
		this.usuario.getInstance();
		@SuppressWarnings("unused")
		ListaUsuarios listaUsuarios = new ListaUsuarios();

	}

}
