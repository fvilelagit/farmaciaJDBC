package dao;

import java.util.List;

import entidades.Registro;

public interface RegistroDao {

	void inserirRegistro(Registro m);
	void atualizarPedido(Registro m);
	void deletarPorId(Long id);
	Registro buscarPorId(Long id);
	
	void buscarPorCliente(String cpf);
	List<Registro> listarPedido();
	List<Registro> buscarPorMedicamento(Long id);
	void inserirRegistro(String date, int qtdMedicamento, int idMedicamento,
			String cpf);
}
