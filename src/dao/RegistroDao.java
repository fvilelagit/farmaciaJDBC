package dao;

import java.util.List;

import entidades.Registro;

public interface RegistroDao {

	void inserirRegistro(String date, int qtdMedicamento, int idMedicamento,
			String cpf);

	
	void deletarPorId(Long id);
	
	
	Registro buscarPorId(Long id);
	void buscarPorCliente(String cpf);
	
	
	List<Registro> buscarPorMedicamento(Long id);
	List<Registro> listarRegistros();
	

}
