package Model;

public class SituacaoUsuario extends Usuario implements SituacaoUsuarioState {

	@Override
	public void clienteLogado(Usuario usuario) {

		if (usuario != null) {
			if (usuario.getEstado().equals("DESLOGADO")) {
				this.setEstado(getEstado());
				this.setEstado("LOGADO");
				System.out.println("");
				System.out.println(usuario.getNome() + " esta " + getEstado());
			}
		}

	}

	@Override
	public void clienteDeslogado(Usuario usuario) {
		if (usuario != null)
			if (usuario.getEstado().equals("LOGADO")) {
				this.setEstado(getEstado());
				this.setEstado("DESLOGADO");
				System.out.println(usuario.getNome() + " esta " + getEstado());
			}
	}
}
