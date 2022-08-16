package dao;



public interface LogMedicamentoDao {

	
	void inserirLogPositivo(int quantidade, int id_medicamento, String data);
	void exibirEstoqueTotal();
	void validarRetiradaEstoque();
	
	
	void validarRetiradaEstoque(int medicamento_id);
	void inserirLogNegativo(int quantidade, int id_medicamento);
	
}