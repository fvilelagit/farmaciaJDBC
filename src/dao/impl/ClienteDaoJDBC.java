package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.ClienteDao;
import db.DB;
import db.DbException;
import entidades.Cliente;
import entidades.Medicamento;

public class ClienteDaoJDBC implements ClienteDao {

	private Connection conn;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
	
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
			+ nome +": , "
			+ cpf +" ,: "
			+ telefone +": , "
			+ data +"  ;"
			+ " foram inclu�dos com sucesso!"			
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

		}
	
	}
	
	
	
	@Override
	public void atualizarCliente(int id, String nome, String cpf, String telefone, String data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		PreparedStatement pst = null;

		
		try {
			conn= DB.getConnection();
			
			pst = conn.prepareStatement(
				"update cliente "	
				+ "SET nome= ?, cpf= ?, telefone= ?, data_nasc= ? "
				+ "WHERE id= ?");
	
			pst.setString(1, nome);
			pst.setString(2, cpf);
			pst.setString(3, telefone);
			pst.setDate(4, new java.sql.Date(sdf.parse(data).getTime()));
			pst.setInt(5, id);
			
			pst.executeUpdate();
			
			System.out.println("Update executado! ");	
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}catch (ParseException e) {
			e.getMessage();
		}
		finally {
			DB.closeResultSet();
			DB.closeStatement();

		}
	}

	@Override
	public void deletarPorId(int id) {
		PreparedStatement pst = null;

		try {
			conn= DB.getConnection();
			
			pst = conn.prepareStatement(
				"delete from cliente "	
				+ "WHERE id= ?");
	
			pst.setDouble(1,id);


			
			pst.executeUpdate();
			
			System.out.printf("Cliente de id %d deletado com sucesso! ", id);	
			System.out.println();
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet();
			DB.closeStatement();
		}
	}


	@Override
	public Cliente buscarPorId(Long id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Cliente cli = new Cliente();
		try {
			conn = DB.getConnection();
			pst = conn.prepareStatement(
					"SELECT * FROM cliente "		
					+ "WHERE id = ?;");
			pst.setLong(1, id);
			System.out.println(pst);
			rs = pst.executeQuery();
			rs.next();
			
			System.out.println("Id:" + rs.getLong("id") 
			+ " Nome: " + rs.getString("nome")
			+ " CPF: " + rs.getString("cpf")
			+ " Telefone:  " + rs.getInt("telefone")
			+ " Data Nascimento: " + rs.getDate("data_nasc"));

			cli.setId(rs.getLong("id"));
			cli.setNome(rs.getString("nome"));
			cli.setCpf(rs.getString("cpf"));
			cli.setTelefone(rs.getString("telefone"));
			cli.setData_nascimento(rs.getDate("data_nasc"));
			
			System.out.println(cli.getId());
			
		} catch(Exception e) {
			System.out.println("erro: " + e);
		}
		
<<<<<<< HEAD
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(
					"SELECT * FROM cliente "
					+"WHERE id=?"
					);
			pst.setLong(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setCpf(rs.getString("cpf"));
				c.setTelefone(rs.getString("telefone"));
				c.setData_nascimento(rs.getDate("data_nasc"));
				
				return c;
				
			}
			return null;
		
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet();
			DB.closeStatement();

		}
=======
		return cli;

>>>>>>> 13095dca7fe303156c1c7c7b496926582ce39f2d
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

			}
	}
	
}
