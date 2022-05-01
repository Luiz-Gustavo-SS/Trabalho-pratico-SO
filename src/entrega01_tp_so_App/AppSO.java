package entrega01_tp_so_App;

import entrega01_tp_so.BracoFIFO;
import entrega01_tp_so.BracoSjf;

public class AppSO {

	public static void main(String[] args) {

		BracoFIFO bracoFifo = new BracoFIFO();
		bracoFifo.acionarMetodo();
		System.out.print(bracoFifo.calculoTempoMedio() / 3600);
		System.out.println();
		System.out.print("Teste:");
		bracoFifo.getPedidoPorPosicao(1).imprimir();

		BracoSjf bracoSjf = new BracoSjf();
		bracoSjf.acionarMetodo();
		System.out.print(bracoSjf.calculoTempoMedio() / 3600);
		System.out.println();
		System.out.print("Teste sjf:");
		bracoSjf.getPedidoPorPosicao(1).imprimir();
	}

}
