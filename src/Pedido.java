package entrega01_tp_so;

public class Pedido {

	private int numProduto;
	private String nomeCliente;
	private int prioridade;

	private int tempoEspera;
	private int tempoExecucao;

	public Pedido(int numProduto, String nomeCliente, int prioridade, int tempoExecucao) {
		this.setNumProduto(numProduto);
		this.setNomeCliente(nomeCliente);
		this.setPrioridade(prioridade);
		this.setTempoExecucao(tempoExecucao);

	}

	public int getNumProduto() {
		return numProduto;
	}

	public void setNumProduto(int numProduto) {
		this.numProduto = numProduto;
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

	public int getTempoEspera() {
		return tempoEspera;
	}

	public void setTempoEspera(int tempoEspera) {
		this.tempoEspera = tempoEspera;
	}

	public int getTempoRetorno() {
		return this.tempoEspera + this.tempoExecucao;
	}

	public int getTempoExecucao() {
		return tempoExecucao;
	}

	public void setTempoExecucao(int tempoExecucao) {
		this.tempoExecucao = tempoExecucao;
	}

}
