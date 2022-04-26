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

	// Getters

	public Relogio getRelogio() {
		return relogio;
	}

	public void setRelogio(Relogio relogio) {
		this.relogio = relogio;
	}

	public int getNumProdutos() {
		return numProdutos;
	}

	// Setters

	public void addProduto(Produto produto) {
		produtos[numProdutos++] = produto;
	}

}
