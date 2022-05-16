package entrega01_tp_so;

public abstract class Braco {

	protected Pedido pedidos[] = new Pedido[200];
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

	public void addPedido(Pedido pedido) {
		this.pedidos[numPedidoAtual++] = pedido;
	}

	// Metodos gerais
	public void lerPedidos() {
		
		String s = MyIO.readLine();
		int numEntradas = Integer.parseInt(s);

		for (int i = 0; i < numEntradas; i++) {
			Pedido pedido = new Pedido();
			s = MyIO.readLine();// while (!s.equals("FIM")) {
			if (s.indexOf(";") > -1) {
				String[] stringArray = s.split(";");

				if (stringArray.length > 0) {
					pedido.setNomeCliente(stringArray[0]);
					pedido.setQuantProduto(Integer.parseInt(stringArray[1]));
					if(Integer.parseInt(stringArray[2])!=0) {
					pedido.setPrioridade(Integer.parseInt(stringArray[2]));
					}else {
						pedido.setPrioridade(1000);
					}
				}
			}
			this.addPedido(pedido);
			//this.pedidos[i].imprimir();
		}
	}

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

	public double calculoTempoMedio() {
		double resp = 0;
		for (int i = 0; i < this.getNumPedidoAtual(); i++) {
			resp += pedidos[i].getTempoRetorno();
		}
		return (resp / this.getNumPedidoAtual());
	}
}
