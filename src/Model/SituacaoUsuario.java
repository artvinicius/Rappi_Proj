package Model;

public class SituacaoUsuario  implements SituacaoUsuarioState {

	@Override
	public void clienteValidado(Usuario usuario) {

		if (usuario != null)

			System.out.println("Cadastro Válidado com Sucesso!");

	}

	@Override
	public void clienteInvalidado(Usuario usuario) {
		if (usuario == null)

			System.out.println("Cadastro Inválido!");
	}
}
