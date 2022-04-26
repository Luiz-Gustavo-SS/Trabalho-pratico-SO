import java.util.*;

public class BracoSjf extends Braco {

	@Override
	public void acionarMetodo(Caixa caixa) {
		ordenarPedidos();
		for (int i = 0; i < getNumPedidoAtual(); i++) {
			embalar(pedidos[i], caixa);
		}
		calculoTempoMedio();
	}

	// Implementação do algoritmo de ordenação

	public void ordenarPedidos() {
		for (int i = 1; i < pedidos.length; i++) {
			Pedido pedidoAtual = pedidos[i];
			int j = i - 1;
			while(j >= 0 && pedidoAtual.getPrioridade() < pedidos[j].getPrioridade()) {
				pedidos[j+1] = pedidos[j];
				j--;
			}
			pedidos[j+1] = pedidoAtual;
		}
	}
}
