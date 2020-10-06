package Model;

public class Produtos {

	private int codigo;
	private String nome;
	private double valor;

	public Produtos(int codigo, String nome, double valor) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Cód.: " + codigo + " - " + nome + ", R$ " + valor;
	}

}
