package dao;

public interface RepositorioDao {
	
	void adicionarMedicamentoEstoque(int qtd, int id_medicamento);
	void atualizarEstoque(int qtd, int id_medicamento);
	// Como seria a lógica pra gerar um log de retirada 
	// Como seria a lógica pra gerar um log de soma 
	
	
	
}
