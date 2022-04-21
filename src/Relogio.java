package entrega01_tp_so;

public class Relogio {
    private double tempoAtual = 0.0;

    // Getter
    public double getTempoAtual() {
        return tempoAtual;
    }

    // Metodos gerais

    // Volta o tempo do relogio para 0
    public void resetaTempo(){
    	this.tempoAtual = 0.0;
    }

    // Recebe um valor de tempo e adapta o relogio
    public void passaTempo(double tempo){
        this.tempoAtual+=tempo;
    }

    
}
