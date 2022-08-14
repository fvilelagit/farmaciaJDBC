package dao;

import java.util.List;


import entidades.Cliente;

public interface ClienteDao {

	void inserirCliente(String nome, String cpf, String telefone, String data);
	
	void atualizarCliente();
	void deletarPorId(Long id);
	Cliente buscarPorId(Long id);

	void exibirClientes();
	
	

}
