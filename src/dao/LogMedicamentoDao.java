package dao;

import java.util.Date;

public interface LogMedicamentoDao {

	void inserirLogPositivo(int quantidade, int id_medicamento);
	void inserirLogNegativo(int quantidade, int id_medicamento);
	void exibirEstoqueTotal();
	
	
}