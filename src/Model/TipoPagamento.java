package Model;

public class TipoPagamento extends Pagamento {

	public String tipo(int tipo) {
		
		if (tipo == 1) {
			return "Cartao";
		}
		if (tipo == 2) {
			return "Prime";
		}
		if (tipo == 3) {
			return "RappiPay";
		}
		if (tipo == 4) {
			return "QRCode";
		}
		return null;

	}

}
