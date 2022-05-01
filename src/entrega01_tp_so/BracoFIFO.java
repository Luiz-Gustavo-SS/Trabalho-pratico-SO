package entrega01_tp_so;

public class BracoFIFO extends Braco {

	@Override
	public void acionarMetodo() {
		this.lerPedidos();
		Armazem armazem = new Armazem();
		System.out.print("verifica vetor Pedidos: " ); 
		this.getPedidoPorPosicao(2).imprimir();
		for (int i = 0; i < this.getNumPedidoAtual(); i++) {
			Pedido aux = this.getPedidoPorPosicao(i);
			
			double tempoExec = 0;

			while (aux.getQuantProduto() > 0) {
				Caixa caixa = new Caixa();
				this.embalar(new Produto(), caixa, aux.reduzQuantProduto());
				caixa.getRelogio().getTempoAtual();
				this.transicionaCaixa(armazem, caixa);
				tempoExec = this.getRelogio().getTempoAtual();
				System.out.println(i + " TempoExec: " + tempoExec);
				System.out.println("Num Produtos Sobrando: " + aux.getQuantProduto());
			}
			
			if (i > 0) {
				this.getPedidoPorPosicao(i).setTempoEspera(this.getPedidoPorPosicao(i - 1).getTempoExecucao());
			}
			this.getPedidoPorPosicao(i).setTempoExecucao(tempoExec);
		}
	}

}
