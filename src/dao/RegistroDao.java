package dao;

import java.util.List;

import entidades.Registro;

public interface RegistroDao {

	void inserirRegistro(String date, int qtdMedicamento, int idMedicamento,
			String cpf);

	void buscarPorCliente(String cpf);
	
	
	void deletarPorId(Long id);
	
	
	List<Registro> buscarPorMedicamento(Long id);
	List<Registro> listarRegistros();
	

}
