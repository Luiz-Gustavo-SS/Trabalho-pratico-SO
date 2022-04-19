package entrega01_tp_so;

public abstract class Braco {
    private Pedido Pedidos; // Nome do atributo não foi especificado

    // Getter

    public Pedido getAttribute6() {
        return Pedidos;
    }

    // Setter

    // Metodos gerais

    public void embalar(Produto produto, Caixa caixa){
        caixa.addProduto(produto);
    }

    public abstract void acionarMetodo();
    
}
