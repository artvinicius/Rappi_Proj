package Model;

public class Pedido {

	private double valorUnd;
	private int quantProduto;
	private String tpg;
	private String dia;

	public Pedido() {

	}

	public Pedido(double valorUnd, String tpg, String dia) {
		this.dia = dia;
		this.tpg = tpg;
		this.valorUnd = valorUnd;
	}

	public double valorTotal(double valorUnd, int quantProduto) {
		this.valorUnd = valorUnd;
		this.quantProduto = quantProduto;

		return valorUnd * quantProduto;
	}

	public double getValorUnd() {
		return valorUnd;
	}

	public void setValorUnd(double valorUnd) {
		this.valorUnd = valorUnd;
	}

	public int getQuantProduto() {
		return quantProduto;
	}

	public void setQuantProduto(int quantProduto) {
		this.quantProduto = quantProduto;
	}

	public String getTpg() {
		return tpg;
	}

	public void setTpg(String tpg) {
		this.tpg = tpg;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

}
