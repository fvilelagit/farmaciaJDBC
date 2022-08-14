package dao;

import java.util.List;

import entidades.Medicamento;

public interface MedicamentoDao {

		void inserirMedicamento(Medicamento  m);
		void atualizarMedicamento(Medicamento m);
		
		
		void deletarPorId(int id);
		Medicamento buscarPorId(int id);
		List<Medicamento> listarMedicamentos();
		
		
		Medicamento buscarPorId_CONNECTION_ON(int id);
		
}

