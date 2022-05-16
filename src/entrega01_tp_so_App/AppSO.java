package entrega01_tp_so_App;

import entrega01_tp_so.BracoFIFO;
import entrega01_tp_so.BracoSjf;

public class AppSO {

	public static void main(String[] args) {

		BracoFIFO bracoFifo = new BracoFIFO();
		BracoSjf bracoSjf = new BracoSjf();

		// Instanciado dois braços/esteiras para o método FIFO
		Thread primeiroBracoFifo = new Thread(bracoFifo);
		Thread segundoBracoFifo = new Thread(bracoFifo);

		// Instanciado dois braços/esteiras para o método SJF
		Thread primeiroBracoSjf = new Thread(bracoSjf);
		Thread segundoBracoSjf = new Thread(bracoSjf);


		// Braco FIFO
		primeiroBracoFifo.start();
		segundoBracoFifo.start();

		// bracoFifo.acionarMetodo();  ---> Relocado para os Bracos
		System.out.print(bracoFifo.calculoTempoMedio() / 3600);
		System.out.println();
		System.out.print("Teste:");
		bracoFifo.getPedidoPorPosicao(1).imprimir();

		// Braco SJF
		primeiroBracoSjf.start();
		segundoBracoSjf.start();
		
		bracoSjf.acionarMetodo();
		System.out.print(bracoSjf.calculoTempoMedio() / 3600);
		System.out.println();
		System.out.print("Teste sjf:");
		bracoSjf.getPedidoPorPosicao(1).imprimir();
	}

}
