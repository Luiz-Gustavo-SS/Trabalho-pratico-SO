public class Armazem {
    private Caixa caixas[];
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
