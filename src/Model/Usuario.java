package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {

	Scanner entrada = new Scanner(System.in);

	private String nome;
	private String codIdentificador;
	private double pontuacao;
	private static Usuario uniqueInstance;
	double total = 0;

	private List<Double> pontos = new ArrayList<Double>();

	public Usuario(String nome, String codIdentificador) {
		this.nome = nome;
		this.codIdentificador = codIdentificador;

	}

	public Usuario() {
	}
	// Method FACADE

	public static synchronized Usuario getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Usuario();

		return uniqueInstance;
	}

	public double totalPontos() {

		for (int n = 0; n < pontos.size(); n++) {
			total = total + pontos.get(n);
		}
		return total;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(double pontuacao) {
		this.pontuacao = pontuacao;
	}

	public String getCodIdentificador() {
		return codIdentificador;
	}

	public void setCodIdentificador(String codIdentificador) {
		this.codIdentificador = codIdentificador;
	}

	public List<Double> getPontos() {
		return pontos;
	}

	public void setPontos(List<Double> pontos) {
		this.pontos = pontos;
	}

	@Override
	public String toString() {
		return "Código do Usuário: " + this.codIdentificador + " | Nome: " + this.nome;
	}

}
