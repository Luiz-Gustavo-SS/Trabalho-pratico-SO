public class Relogio {
    private double tempoAtual = 0.0;

    // Getter
    public double getTempoAtual() {
        return tempoAtual;
    }

    // Setter
    public void setTempoAtual(double tempoAtual) {
        this.tempoAtual = tempoAtual;
    }

    // Métodos gerais

    // Volta o tempo do relógio para 0
    public void resetaTempo(){
        setTempoAtual(0.0);
    }

    // Recebe um valor de tempo e adapta o relógio
    public void passaTempo(double tempo){
        setTempoAtual(getTempoAtual() + tempo);
    }

    
}
