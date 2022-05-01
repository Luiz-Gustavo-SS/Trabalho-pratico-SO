package entrega01_tp_so;

public class Armazem {
    private Caixa caixas[] = new Caixa[1000];
    private int numCaixas = 0;

    // Getter

    public int getNumCaixas() {
        return numCaixas;
    }

    // Adicionar uma caixa ao armazem

    public void adicionaCaixa(Caixa caixa) {
        caixas[numCaixas] = caixa;
        this.numCaixas++;
    }

}
