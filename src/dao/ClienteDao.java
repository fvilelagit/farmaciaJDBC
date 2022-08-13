package dao;

import java.util.List;

import entidades.Cliente;

public interface ClienteDao {

	void inserirCliente(Cliente  m);
	void atualizarCliente(Cliente m);
	void deletarPorId(Long id);
	Cliente buscarPorId(Long id);
	List<Cliente> listarClientes();
}
