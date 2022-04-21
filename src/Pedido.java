package entrega01_tp_so;

public class Pedido {
	
	private int numProduto;
	private String nomeCliente;
	private int prioridade;
	
	public Pedido(int numProduto, String nomeCliente, int prioridade) {
		this.setNumProduto(numProduto);
		this.setNomeCliente(nomeCliente);
		this.setPrioridade(prioridade);
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
	
	
	
}
