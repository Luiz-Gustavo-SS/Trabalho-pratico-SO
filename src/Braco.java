package entrega01_tp_so;

public abstract class Braco {

	private Pedido pedidos[] = new Pedido[200];
	private int numPedidoAtual = 0;
	Relogio relogio = new Relogio();

	// Getter

	public Pedido[] getPedidos() {
		return pedidos;
	}

	public int getNumPedidoAtual() {
		return this.numPedidoAtual;
	}

	// Setter

	public void addPedido(Pedido pedido) {
		this.pedidos[numPedidoAtual++] = pedido;
	}

	// Metodos gerais

	public void lerPedidos() {

	}

	public void embalar(Produto produto, Caixa caixa) {
		if (caixa.getNumProdutos() < Caixa.MAX_PRODUTOS) {
			caixa.addProduto(produto);
			relogio.passaTempo(Caixa.TEMPO_EMPACOTAR);
			caixa.setRelogio(relogio);
		}
	}

	public abstract void acionarMetodo();

	public void transicionaCaixa(Armazem armazem, Caixa caixa) {
		armazem.adicionaCaixa(caixa);
		relogio.passaTempo(Caixa.TRANSICAO);

	}

	public double calculoTempoMedio() {
		double resp = 0;
		for (int i = 0; i < this.getNumPedidoAtual(); i++) {
			resp += pedidos[i].getTempoRetorno();
		}
		return resp / this.getNumPedidoAtual();
	}
}
