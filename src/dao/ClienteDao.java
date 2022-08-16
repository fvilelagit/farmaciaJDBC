package dao;

import java.util.List;


import entidades.Cliente;

public interface ClienteDao {

	void inserirCliente(String nome, String cpf, String telefone, String data);
	void exibirClientes();
	Cliente buscarPorId(Long id);
	
	
	void atualizarCliente(int id, String nome, String cpf, String telefone, String data);
	void deletarPorId(int id);

	
	

}
