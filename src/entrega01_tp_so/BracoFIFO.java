package entrega01_tp_so;

public class BracoFIFO extends Braco implements Runnable {

	@Override
	public void acionarMetodo() {
		Armazem armazem = new Armazem();
		this.ordenarPedidosPorTempoChegadaBubbleSort();
		for (int i = 0; i < this.getNumPedidoAtual(); i++) {
			Pedido aux = this.getPedidoPorPosicao(i);

			double tempoExec;
			double tempoInicial = this.getRelogio().getTempoAtual();

			while (aux.getQuantProduto() > 0) {
				Caixa caixa = new Caixa();
				this.embalar(new Produto(), caixa, aux.reduzQuantProduto());
				caixa.getRelogio().getTempoAtual();
				this.transicionaCaixa(armazem, caixa);
			}
			tempoExec = this.getRelogio().getTempoAtual() - tempoInicial;
			if (i > 0) {
				this.getPedidoPorPosicao(i).setTempoEspera(this.getPedidoPorPosicao(i - 1).getTempoRetorno());
			}
			this.getPedidoPorPosicao(i).setTempoExecucao(tempoExec);
			// this.getPedidoPorPosicao(i).imprimir();
		}
	}
	

	public void ordenarPedidosPorTempoChegadaBubbleSort() {
		for (int i = 0; i < this.getNumPedidoAtual(); i++) {
			Pedido pedidoAtual = pedidos[i];
			int j = i - 1;
			while (j >= 0 && pedidoAtual.getTempoChegada() < pedidos[j].getTempoChegada()) {
				pedidos[j + 1] = pedidos[j];
				j--;
			}
			pedidos[j + 1] = pedidoAtual;
		}
	}

	@Override
	public void run() {
		this.acionarMetodo();
	}

}
