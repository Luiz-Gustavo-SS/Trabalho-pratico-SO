package entrega01_tp_so;

public class BracoSjf extends Braco {

	@Override
	public void acionarMetodo() {
		this.lerPedidos();
		this.ordenarPedidosPorPrioridadeBubbleSort();
		Armazem armazem = new Armazem();
		
		for (int i = 0; i < this.getNumPedidoAtual(); i++) {
			Pedido aux = this.getPedidoPorPosicao(i);
			
			double tempoExec = 0;

			while (aux.getQuantProduto() > 0) {
				Caixa caixa = new Caixa();
				this.embalar(new Produto(), caixa, aux.reduzQuantProduto());
				caixa.getRelogio().getTempoAtual();
				this.transicionaCaixa(armazem, caixa);
				tempoExec = this.getRelogio().getTempoAtual();
			}
			if (i > 0) {
				this.getPedidoPorPosicao(i).setTempoEspera(this.getPedidoPorPosicao(i - 1).getTempoRetorno());
			}
			this.getPedidoPorPosicao(i).setTempoExecucao(tempoExec);
			//this.getPedidoPorPosicao(i).imprimir();
		}
	}
	
	public void ordenarPedidosPorPrioridadeBubbleSort() {
        for (int i = 0; i < this.getNumPedidoAtual(); i++) {
            Pedido pedidoAtual = pedidos[i];
            int j = i - 1;
            while(j >= 0 && pedidoAtual.getPrioridade() < pedidos[j].getPrioridade()) {
                pedidos[j+1] = pedidos[j];
                j--;
            }
            pedidos[j+1] = pedidoAtual;
        }
    }
	

}
