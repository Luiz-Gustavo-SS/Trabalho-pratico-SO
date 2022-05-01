package entrega01_tp_so_App;

import entrega01_tp_so.BracoFIFO;

public class AppSO {

	public static void main(String[] args) {
		BracoFIFO bracoFifo = new BracoFIFO();
		bracoFifo.acionarMetodo();
		System.out.print(bracoFifo.calculoTempoMedio()/3600);
		System.out.println();
		System.out.print("Teste:");
		bracoFifo.getPedidoPorPosicao(1).imprimir();
	}

}
