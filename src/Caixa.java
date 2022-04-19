package entrega01_tp_so;

public class Caixa {
    
	// Constantes
    public static final double TEMPO_EMPACOTAR = 5.0;
    public static final double TRANSICAO = 0.5;
    public static final int CAPACIDADE_MAXIMA = 5;
    public static final int MAX_PRODUTOS = 20;
    
    // Atributos
    private Produto produtos[];
    private int numProdutos = 0;

    Relogio relogio = new Relogio();

    // Metodos gerais

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
