package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import dao.MedicamentoDao;
import db.DB;
import db.DbException;
import entidades.Medicamento;

public class MedicamentoDaoJDBC implements MedicamentoDao {

	private Connection conn;

	public MedicamentoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void inserirMedicamento(String nome, String marca, Double valor, Boolean generico, boolean remedio) {
	
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn= DB.getConnection();
			
			pst = conn.prepareStatement(
				"insert into medicamento "	
				+ "(nome, marca, valor, generico, remedio)"
				+ "values "
				+ "(?,?,?,?,?)",
				pst.RETURN_GENERATED_KEYS);
			pst.setString(1, nome);
			pst.setString(2, marca);
			pst.setDouble(3, valor);
			pst.setBoolean(4, generico);
			pst.setBoolean(5, generico);
			
			System.out.println("Teste ");
			
			int linhasAfetadas = pst.executeUpdate();
			
			if (linhasAfetadas > 0) {
				rs = pst.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("ID =" + id);
				}
			}
			
			
			System.out.println(linhasAfetadas + " linhas afetadas.");
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());

		}finally {
			DB.closeResultSet();
			DB.closeStatement();

		}
	}




	@Override
	public void atualizarValorMedicamento(String nome, Double valor) {
	PreparedStatement pst = null;

		try {
			conn= DB.getConnection();
			
			pst = conn.prepareStatement(
				"update medicamento "	
				+ "SET valor= ? "
				+ "WHERE nome= ?");
	
			pst.setDouble(1,valor);
			pst.setString(2, nome);

			
			pst.executeUpdate();
			
			System.out.println("Update executado! ");	
			
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
	public void deletarPorId(int id) {
		PreparedStatement pst = null;

		try {
			conn= DB.getConnection();
			
			pst = conn.prepareStatement(
				"delete from medicamento "	
				+ "WHERE id= ?");
	
			pst.setDouble(1,id);


			
			pst.executeUpdate();
			
			System.out.printf("Medicamento de id %d deletado com sucesso! ", id);	
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
	public Medicamento buscarPorId(int id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT * FROM medicamento " + "WHERE id=?");
			pst.setLong(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				Medicamento m = new Medicamento();
				m.setId(rs.getLong("id"));
				m.setNome(rs.getString("nome"));
				m.setMarca(rs.getString("marca"));
				m.setValor(rs.getDouble("valor"));
				m.setGenerico(rs.getBoolean("generico"));
				m.setRemedio(rs.getBoolean("remedio"));

				return m;

			}
			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet();
			DB.closeStatement();

		}
	}

	public Medicamento buscarPorId_CONNECTION_ON(int id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT * FROM medicamento " + "WHERE id=?");
			pst.setLong(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				Medicamento m = new Medicamento();
				m.setId(rs.getLong("id"));
				m.setNome(rs.getString("nome"));
				m.setMarca(rs.getString("marca"));
				m.setValor(rs.getDouble("valor"));
				m.setGenerico(rs.getBoolean("generico"));
				m.setRemedio(rs.getBoolean("remedio"));

				return m;

			}
			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {

		}

	}

	@Override
	public List<Medicamento> listarMedicamentos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Medicamento buscarPorNome(String nome) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Medicamento m = new Medicamento();
		try {
			pst = conn.prepareStatement(
					"SELECT * FROM medicamento "
					+"WHERE nome like ?"
					);
			pst.setString(1, "%"+nome+"%");
			rs = pst.executeQuery();
			if (rs.next()) {
				m.setId(rs.getLong("id"));
				m.setNome(rs.getString("nome"));
				m.setMarca(rs.getString("marca"));
				m.setValor(rs.getDouble("valor"));
				m.setRemedio(rs.getBoolean("remedio"));
				m.setGenerico(rs.getBoolean("generico"));
			}
		} catch (Exception e){
			System.out.println("Erro: " + e);
		}
		return m;
	}

}
