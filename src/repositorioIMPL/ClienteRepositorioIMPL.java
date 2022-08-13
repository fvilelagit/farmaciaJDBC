package repositorioIMPL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import entidades.Cliente;

public class ClienteRepositorioIMPL {
	// Esboço de uma classe teste de conexão 
	/* 
	
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;

	//Inserir Clientes e retornar o id gerado
	public void inserirCliente(String nome, String cpf, String telefone, String data) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		PreparedStatement pst = null;
		
		try {
			conn= DB.getConnection();
			pst = conn.prepareStatement(
				"insert into clientes"	
				+ "(nome, cpf, telefone,data_nasc)"
				+ "values"
				+ "(?,?,?,?,?)",
				pst.RETURN_GENERATED_KEYS);
			pst.setString(1, nome);
			pst.setString(2, cpf);
			pst.setString(3, telefone);
			pst.setDate(4, new java.sql.Date(sdf.parse(data).getTime()));
			
			int linhasAfetadas = pst.executeUpdate();
			
			if (linhasAfetadas > 0) {
				ResultSet rs = pst.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("ID =" + id);
				}
			}
			
			System.out.println("O dados do cliente: "
			+ nome +", "
			+ cpf +", "
			+ telefone +", "
			+ data +"  ;"
			+ " foram incluídos com sucesso!"			
			);
			
			System.out.println(linhasAfetadas + " linhas afetadas.");

		}catch(SQLException e) {
			e.getMessage();
		} finally {
			DB.closeResultSet();
			DB.closeStatement();
			DB.closeConnection();
		}
		
	}
	
	
	
	//Exibir a lista de todos os clientes 
	public void exibirClientes() {
		try {
			String query =  "SELECT * FROM clientes";
			st = conn.createStatement();
			rs= st.executeQuery(query);
			while(rs.next()) {
				System.out.println("Id:" + rs.getLong("id_cliente") 
				+ " Nome: " + rs.getString("nome")
				+ " CPF: " + rs.getString("cpf")
				+ " Telefone" + rs.getInt("telefone")
				+ " Data Nascimento" + rs.getDate("data_nasc"));
			}
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			} finally {
				DB.closeResultSet();
				DB.closeStatement();
				DB.closeConnection();
			}

		
	}
	
	// Retornar uma lista de Clientes
	List <Cliente> listaClientes(){
		List<Cliente> clientes = new ArrayList();
		
		try {
			String query =  "SELECT * FROM clientes";
			st = conn.createStatement();
			rs= st.executeQuery(query);
			
			while(rs.next()) {
				Cliente cliente = new Cliente();			
				cliente.setId(rs.getLong("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setData_nascimento(rs.getDate("data_nasc"));
				clientes.add(cliente);
			}
			return clientes;
		
		} catch(SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeResultSet();
			DB.closeStatement();
			DB.closeConnection();
		}
	
	}	
*/
}
