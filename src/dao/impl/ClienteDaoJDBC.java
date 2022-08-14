package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import dao.ClienteDao;
import db.DB;
import db.DbException;
import entidades.Cliente;

public class ClienteDaoJDBC implements ClienteDao {

	private Connection conn;
	
	public ClienteDaoJDBC(Connection conn){
		this.conn = conn;
	}
	
	
	@Override
	public void inserirCliente(String nome, String cpf, String telefone, String data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn= DB.getConnection();
			
			pst = conn.prepareStatement(
				"insert into cliente "	
				+ "(nome, cpf, telefone,data_nasc) "
				+ "values "
				+ "(?,?,?,?)",
				pst.RETURN_GENERATED_KEYS);
			pst.setString(1, nome);
			pst.setString(2, cpf);
			pst.setString(3, telefone);
			pst.setDate(4, new java.sql.Date(sdf.parse(data).getTime()));
			
			System.out.println("Teste ");
			
			int linhasAfetadas = pst.executeUpdate();
			
			if (linhasAfetadas > 0) {
				rs = pst.getGeneratedKeys();
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
			throw new DbException(e.getMessage());
			
		}catch (ParseException e) {
			e.getMessage();
		}
		finally {
			DB.closeResultSet();
			DB.closeStatement();
			DB.closeConnection();
		}
		
	}
	@Override
	public void atualizarCliente() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarPorId(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente buscarPorId(Long id) {
		
		return null;
	}


	public void exibirClientes() {
		Statement st = null;
		ResultSet rs = null;
		
		
		try {
			conn = DB.getConnection();
			
			String query =  "SELECT * FROM cliente";
			st = conn.createStatement();
			rs= st.executeQuery(query);
			
			while(rs.next()) {
				System.out.println("Id:" + rs.getLong("id") 
				+ " Nome: " + rs.getString("nome")
				+ " CPF: " + rs.getString("cpf")
				+ " Telefone" + rs.getInt("telefone")
				+ " Data Nascimento" + rs.getDate("data_nasc"));
			}
			
			System.out.println("TEste");
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
				
			} finally {
				DB.closeResultSet();
				DB.closeStatement();
				DB.closeConnection();
			}

		
	}

}
