package entrega01_tp_so_App;

import entrega01_tp_so.BracoFIFO;
import entrega01_tp_so.BracoSjf;
import entrega01_tp_so.Pedido;

public class AppSO {

	private static int numPedidos = 0;
	private static Pedido[] pedidos = new Pedido[400];

	public static void lerPedidos() {

		String s = MyIO.readLine();
		int numEntradas = Integer.parseInt(s);
		numPedidos = numEntradas;
		for (int i = 0; i < numEntradas; i++) {
			Pedido pedido = new Pedido();
			s = MyIO.readLine();// while (!s.equals("FIM")) {
			if (s.indexOf(";") > -1) {
				String[] stringArray = s.split(";");

				if (stringArray.length > 0) {
					pedido.setNomeCliente(stringArray[0]);
					pedido.setQuantProduto(Integer.parseInt(stringArray[1]));
					if (Integer.parseInt(stringArray[2]) != 0) {
						pedido.setPrioridade(Integer.parseInt(stringArray[2]));
					} else {
						pedido.setPrioridade(10000);
					}
					pedido.setTempoChegada(Integer.parseInt(stringArray[3])*60);
				}
			}
			AppSO.pedidos[i] = pedido;
			// this.pedidos[i].imprimir();
		}
	}

	public static void main(String[] args) throws InterruptedException {

		BracoFIFO bracoFifo1 = new BracoFIFO();
		BracoFIFO bracoFifo2 = new BracoFIFO();

		BracoSjf bracoSjf1 = new BracoSjf();
		BracoSjf bracoSjf2 = new BracoSjf();

		lerPedidos();
		System.out.println();
		for (int i = 0; i < numPedidos / 2; i++)
			bracoFifo1.addPedido(AppSO.pedidos[i]);
		for (int j = numPedidos / 2; j < numPedidos; j++)
			bracoFifo2.addPedido(AppSO.pedidos[j]);
		
		Thread primeiroBracoFifo = new Thread(bracoFifo1);
		Thread segundoBracoFifo = new Thread(bracoFifo2);
		primeiroBracoFifo.start();
		segundoBracoFifo.start();
		primeiroBracoFifo.join();
		segundoBracoFifo.join();
		System.out.println("Tempo FIFO:" + bracoFifo1.calculoTempoTotalDeFabricacao() / 3600);

		for (int i = 0; i < numPedidos / 2; i++)
			bracoSjf1.addPedido(AppSO.pedidos[i]);
		for (int i = numPedidos / 2; i < numPedidos; i++)
			bracoSjf2.addPedido(AppSO.pedidos[i]);
		
		Thread primeiroBracoSjf = new Thread(bracoSjf1);
		Thread segundoBracoSjf = new Thread(bracoSjf2);

		primeiroBracoSjf.start();
		segundoBracoSjf.start();
		primeiroBracoSjf.join();
		segundoBracoSjf.join();
		System.out.println("Tempo SJF:" + bracoSjf1.calculoTempoTotalDeFabricacao() / 3600);
	}

}
