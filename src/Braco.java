
public abstract class Braco {
	
    protected Pedido pedidos[] = new Pedido[200];
    private int numPedidoAtual = 0;

    Relogio relogio = new Relogio();
    Armazem armazem = new Armazem();

    // Getter

    public Pedido[] getPedidos() {
        return pedidos;
    }

    public int getNumPedidoAtual() {
        return numPedidoAtual;
    }

    // Setter
    
    public void addPedido(Pedido pedido) {
    	this.pedidos[numPedidoAtual++]=pedido;
    }

    // Metodos gerais
    
    public void lerPedidos() {
        //////////////////////////////////////////
        /////////////////////////////////////////
        ////////////////////////////////////////
    }

    // Embala o produto

    public void embalar(Produto produto, Caixa caixa){
        if(caixa.getNumProdutos() < Caixa.MAX_PRODUTOS - 1){ 
            embalaCaixa(produto, caixa);
        }
        else if(caixa.getNumProdutos() == Caixa.MAX_PRODUTOS - 1){
            embalaCaixa(produto, caixa);
            transicionaCaixa(caixa);
        }
    }

    public void embalaCaixa(Produto produto, Caixa caixa){
        caixa.addProduto(produto);
        relogio.passaTempo(Caixa.TEMPO_EMPACOTAR);
        caixa.setRelogio(relogio);
    }

    // Transiciona a caixa para o armazem

	public void transicionaCaixa(Caixa caixa){
        armazem.adicionaCaixa(caixa);
        relogio.passaTempo(Caixa.TRANSICAO);
    }


    // Calcula o tempo médio da atividade

    public double calculoTempoMedio() {
        double resp = 0;
        for(int i=0; i<this.getNumPedidoAtual(); i++) {
            resp+=pedidos[i].getTempoRetorno();
        }
        return resp/this.getNumPedidoAtual();
    }

    // Aciona o método, implementando os algoritmos escolhidos

    public abstract void acionarMetodo(Caixa caixa);

}
