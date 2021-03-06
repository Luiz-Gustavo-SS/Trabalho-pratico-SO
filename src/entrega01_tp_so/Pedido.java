package entrega01_tp_so;

public class Pedido {

	private int quantProduto;
	private String nomeCliente;
	private int prioridade;
	private int tempoChegada;

	private double tempoEspera;
	private double tempoExecucao;

	public Pedido() {

	}

	public Pedido(int numProduto, String nomeCliente, int prioridade) {
		this.setQuantProduto(numProduto);
		this.setNomeCliente(nomeCliente);
		this.setPrioridade(prioridade);
	}

	public int getQuantProduto() {
		return quantProduto;
	}

	public int reduzQuantProduto() {
		int inserir;
		if (this.getQuantProduto() >= 20) {
			this.quantProduto -= 20;
			inserir = 20;
		} else {
			inserir=this.quantProduto;
			this.quantProduto=0;
		}
		return inserir;
	}

	public void setQuantProduto(int numProduto) {
		this.quantProduto = numProduto;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public double getTempoEspera() {
		return tempoEspera;
	}

	public void setTempoEspera(double tempoEspera) {
		this.tempoEspera = tempoEspera - this.getTempoChegada();
	}

	public double getTempoRetorno() {
		return this.tempoEspera + this.tempoExecucao;
	}

	public double getTempoExecucao() {
		return tempoExecucao;
	}

	public void setTempoExecucao(double tempoExecucao) {
		this.tempoExecucao = tempoExecucao;
	}

	public void imprimir() {
		System.out.println(this.getNomeCliente() + " ## " + this.getTempoEspera() + " ## " + this.getTempoExecucao());
	}

	public int getTempoChegada() {
		return tempoChegada;
	}

	public void setTempoChegada(int tempoChegada) {
		this.tempoChegada = tempoChegada;
	}

}
