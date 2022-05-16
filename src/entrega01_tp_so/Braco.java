package entrega01_tp_so;

public abstract class Braco {

	protected Pedido pedidos[] = new Pedido[500];
	private int numPedidoAtual = 0;
	private Relogio relogio = new Relogio();

	// Getter

	public Relogio getRelogio() {
		return relogio;
	}

	public Pedido getPedidoPorPosicao(int posicao) {
		return this.pedidos[posicao];
	}

	public Pedido[] getPedidos() {
		return pedidos;
	}

	public int getNumPedidoAtual() {
		return this.numPedidoAtual;
	}

	// Setter

	public void setPedidos(Pedido[] pedidos) {
		this.pedidos = pedidos;
	}

	public void addPedido(Pedido pedido) {
		this.pedidos[numPedidoAtual++] = pedido;
	}

	// Metodos gerais

	public void embalar(Produto produto, Caixa caixa, int quantidadeInserir) {

		// if (caixa.getNumProdutos() < Caixa.MAX_PRODUTOS) {
		for (int i = 0; i < quantidadeInserir; i++) {
			caixa.addProduto(produto);
		}
		// }
		// else if(caixa.getNumProdutos() == Caixa.MAX_PRODUTOS) {
		relogio.passaTempo(Caixa.TEMPO_EMPACOTAR);
		caixa.setRelogio(relogio);
		// }

	}

	public abstract void acionarMetodo();
	
	public void transicionaCaixa(Armazem armazem, Caixa caixa) {
		armazem.adicionaCaixa(caixa);
		relogio.passaTempo(Caixa.TRANSICAO);
	}

	public double calculoTempoTotalDeFabricacao() {
		return (pedidos[this.numPedidoAtual - 1].getTempoRetorno());
	}
	

}
