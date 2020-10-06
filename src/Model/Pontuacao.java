package Model;

public class Pontuacao {

	private int forma;
	private double valor;
	private double pontAcum;

	public double pontos(int forma, double valor) {

		if (forma == 1) {

			return valor * 1.5;
		}
		if (forma == 2) {

			return valor * 2.0;
		}
		if (forma == 3) {

			return valor * 1.5;
		}
		if (forma == 4) {

			return valor * 2.0;
		}
		return valor;

	}

	public double totPontos(double pontAcum, double pontos) {
		
		return pontAcum + pontos;
		
	}
	public int getForma() {
		return forma;
	}

	public void setForma(int forma) {
		this.forma = forma;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getPontAcum() {
		return pontAcum;
	}

	public void setPontAcum(double pontAcum) {
		this.pontAcum = pontAcum;
	}
	
	

}
