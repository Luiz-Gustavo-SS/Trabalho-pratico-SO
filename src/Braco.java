package entrega01_tp_so;

public abstract class Braco {
    private Pedido pedidos[];
    Relogio relogio = new Relogio();

    // Getter

    public Pedido[] getPedidos() {
        return pedidos;
    }

    // Setter
    
    public void lerPedidos() {
    	
    }

    // Metodos gerais

    public void embalar(Produto produto, Caixa caixa){
        if(caixa.getNumProdutos() < Caixa.MAX_PRODUTOS){
            caixa.addProduto(produto);
            relogio.passaTempo(Caixa.TEMPO_EMPACOTAR);
            caixa.setRelogio(relogio);
            
        }
    }

    public abstract void acionarMetodo();

	public void transicionaCaixa(Armazem armazem, Caixa caixa){
        armazem.adicionaCaixa(caixa);
        relogio.passaTempo(Caixa.TRANSICAO);

    }

}
