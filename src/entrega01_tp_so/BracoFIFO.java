package entrega01_tp_so;

public class BracoFIFO extends Braco implements Runnable {

	@Override
	public void acionarMetodo() {
		this.lerPedidos();
		Armazem armazem = new Armazem();

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

	@Override
	public void run() {
		acionarMetodo();
		
	}

}
