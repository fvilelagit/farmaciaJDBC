package dao;

public interface PedidoDao {

	
	public void inserirPedido(String data, int qtdMedicamento, int id_medicamento, String cpf, String tipoPagamento);
	public void novoMedicamento(int quantidade, int id_medicamento);
	public int consultaQtd(int idMedicamento);
	
	
	public Double novoMedicamentoD(int quantidade, int id_medicamento);

}