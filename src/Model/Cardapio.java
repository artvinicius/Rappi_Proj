package Model;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {

	public List<Produtos> produto = new ArrayList<Produtos>();

	public Cardapio() {

		// PODE CRIAR UM PADRÃO AQUI

		produto.add(new Produtos(1, "Refrigerante Coca-Cola 300ml", 5.0));
		produto.add(new Produtos(2, "Refrigerante Fanta 300ml", 4.50));
		produto.add(new Produtos(3, "Refrigerante Antartica 300ml", 4.50));
		produto.add(new Produtos(4, "Coxinha Grande", 8.0));
		produto.add(new Produtos(5, "Coxinha Pequena", 2.0));
		produto.add(new Produtos(6, "Empada Salgada", 7.0));
		produto.add(new Produtos(7, "Pastel de Forno", 9.0));
		produto.add(new Produtos(8, "Empada Doce", 8.0));
		produto.add(new Produtos(9, "Brigadeirão", 5.0));
		produto.add(new Produtos(10, "Suco 300ml", 4.0));

	}

	public double valorProduto(int codigo) {
		
	

		for (Produtos produtos : produto) {

			if (codigo == produtos.getCodigo()) {

				return produtos.getValor();
			}
		}
		return 0;
	}
}
