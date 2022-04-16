public class Caixa {
    // Constantes
    private static final double TEMPO_EMPACOTAR = 5.0;
    private static final double TRANSICAO = 0.5;
    private static final int CAPACIDADE_MAXIMA = 5;
    private static final int MAX_PRODUTOS = 20;
    // Atributos
    private Produto produtos[];
    private int numProdutos = 0;

    Relogio relogio = new Relogio();

    // Métodos gerais

    public void transicionaCaixa(Armazem armazem){
        armazem.adicionaCaixa(this);
        relogio.setTempoAtual(TRANSICAO);

    }

    public void addProduto(Produto produto){
        if(numProdutos < MAX_PRODUTOS){
            produtos[numProdutos] = produto;
            this.numProdutos++;

            relogio.setTempoAtual(TEMPO_EMPACOTAR);
        }
    }



    
}
