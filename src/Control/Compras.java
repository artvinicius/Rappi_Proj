package Control;

import Model.Niveis;
import Model.Usuario;

public class Compras extends Niveis {

	Usuario usuario = new Usuario();
	private double pontuacao;

	@Override
	public void classificacao(double pontuacao) {

		System.out.println("\nConfira seus Pontos: ");
		System.out.println(" ");

		usuario.setPontuacao(this.pontuacao);
		this.pontuacao = pontuacao;

		if (this.pontuacao < 2000) {

			System.out.println("Sua Classificação é BRONZE - Total de pontos: " + pontuacao);

		}

		if (this.pontuacao >= 2000 && this.pontuacao < 4000) {

			System.out.println("Sua Classificação é SILVER - Total de pontos: " + pontuacao);

		}

		if (this.pontuacao >= 4000 && this.pontuacao < 10000) {

			System.out.println("Sua Classificação é GOLD - Total de pontos: " + pontuacao);

		}

		if (this.pontuacao >= 10000) {

			System.out.println("Sua Classificação é DIAMANTE - Total de pontos: " + pontuacao);

		}
	}

	@Override
	public void beneficios(double pontuacao) {

		System.out.println("\n--------------------------BENEFICIOS--------------------------");
		System.out.println(" ");

		usuario.setPontuacao(this.pontuacao);
		this.pontuacao = pontuacao;

		if (this.pontuacao < 2000) {

			System.out.println("- Acumula Pontos.");
		}

		if (this.pontuacao >= 2000 && this.pontuacao < 4000) {

			System.out.println(
					"- DESCONTOS:\n  - R$ 37,00 em Bebidas (Para compras a partir de R$ 184,00)\n  - R$ 19,00 n Farmácia (Para compras a partir de R$ 92,00)");
			System.out.println("- R$ 15,00 CashBaak em Beleza (Compras a partir de R$ 15,00)");
			System.out.println("- Atendimento Especilizado");
			System.out.println("- Acumula Pontos");
		}

		if (this.pontuacao >= 4000 && this.pontuacao < 10000) {

			System.out.println(
					"- DESCONTOS:\n  - R$ 37,00 em Bebidas (Para compras a partir de R$ 184,00)\n  - R$ 25,00 n Farmácia (Para compras a partir de R$ 123,00)");
			System.out.println("- Pedido Prioritário");
			System.out.println("- Atendimento Especilizado");
			System.out.println("- Acumula Pontos");
		}

		if (this.pontuacao >= 10000) {

			System.out.println(
					"- DESCONTOS:\n  - R$ 50,00 em Bebidas (Para compras a partir de R$ 246,00)\n  - R$ 37,00 na Farmácia (Para compras a partir de R$ 184,00)");
			System.out.println("- R$ 20,00 CashBaak do Lar (Compras a partir de R$ 200,00)");
			System.out.println("- Rappis Excelentes");
			System.out.println("- Demais Beneficíos");
		}
	}
}
