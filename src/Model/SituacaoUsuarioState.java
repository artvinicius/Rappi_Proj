package Model;

public interface SituacaoUsuarioState {

	//Padrão State

		public void clienteInvalidado(Usuario usuario);
		public void clienteValidado(Usuario usuario);

}
