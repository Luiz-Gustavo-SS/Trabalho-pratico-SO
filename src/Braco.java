public class Braco {
    private int attribute6; // Nome do atributo não foi especificado

    Caixa caixa = new Caixa();

    // Getter

    public int getAttribute6() {
        return attribute6;
    }

    // Setter

    public void setAttribute6(int attribute6) {
        this.attribute6 = attribute6;
    }

    // Métodos gerais

    public void embalar(Produto produto){
        caixa.addProduto(produto);
    }

    public void acionarMetodo(){
        // ?
    }
    
}