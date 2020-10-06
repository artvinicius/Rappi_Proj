package Model;

public class SituacaoUsuario implements SituacaoUsuarioState {

	// Padr�o State

	@Override
	public void clienteValidado(Usuario usuario) {

		if (usuario != null)

			System.out.println("Cadastro V�lidado com Sucesso!");

	}

	@Override
	public void clienteInvalidado(Usuario usuario) {
		if (usuario == null)

			System.out.println("Cadastro Inv�lido!");
	}
}
