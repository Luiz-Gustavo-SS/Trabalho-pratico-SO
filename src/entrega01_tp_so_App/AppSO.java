package entrega01_tp_so_App;

import entrega01_tp_so.BracoFIFO;
import entrega01_tp_so.BracoSjf;

public class AppSO {

	public static void main(String[] args) {

		BracoFIFO bracoFifo = new BracoFIFO();
		bracoFifo.acionarMetodo();
		System.out.println(bracoFifo.calculoTempoMedio() / 3600);

		BracoSjf bracoSjf = new BracoSjf();
		bracoSjf.acionarMetodo();
		System.out.println(bracoSjf.calculoTempoMedio() / 3600);
	}

}
