package dao;

import java.util.List;

import entidades.Medicamento;

public interface MedicamentoDao {

		void inserirMedicamento(String nome, String marca, Double valor, Boolean generico, boolean remedio);
		void atualizarValorMedicamento(String nome, Double valor);
		
		
		void deletarPorId(int id);
		Medicamento buscarPorId(int id);
		
		Medicamento buscarPorNome(String nome);
		
		
		List<Medicamento> listarMedicamentos();
		Medicamento buscarPorId_CONNECTION_ON(int id);
		
}

