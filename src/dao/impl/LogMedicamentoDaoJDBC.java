package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.LogMedicamentoDao;
import db.DB;
import db.DbException;

public class LogMedicamentoDaoJDBC implements LogMedicamentoDao{

	private Connection conn;

	public LogMedicamentoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	public void exibirEstoqueTotal() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn= DB.getConnection();
			String planilhaLog= "estoque_medicamento ";
			String table_medicamento = "medicamento";
			
			pst = conn.prepareStatement(
				"SELECT SUM(A.quantidade) as saldo_estoque, A.id_medicamento," 
				+ "B.nome, b.marca, b.valor, A.data_registro "
				+ "FROM " + planilhaLog+ " A,"
				+  table_medicamento
				+  " B WHERE A.id_medicamento = B.id "
				+	"GROUP BY A.id_medicamento;");
			rs = pst.executeQuery();
			System.out.println(" [§ ------ ESTOQUE DE MEDICAMENTOS ------ §]");
				while(rs.next()) {
					String saldo_estoque = Integer.toString(rs.getInt("saldo_estoque"));
					String id_medicamento = Integer.toString(rs.getInt("id_medicamento"));
					String nome = rs.getString("nome");
					String marca = rs.getString("marca");
					String valor = Double.toString(rs.getDouble("valor"));
					String data_registro ="";
					if(rs.getDate("data_registro")!= null){
						 data_registro = sdf.format(rs.getDate("data_registro"));
					}else {
						 data_registro = "Sem Registro";
					}
		
					System.out.println("Saldo em Estoque : " + saldo_estoque);
					System.out.println("Id : " + id_medicamento);
					System.out.println("Nome : " + nome);
					System.out.println("Marca: " + marca);
					System.out.println("Valor: " + valor);
					System.out.println("Data: " + data_registro);
					System.out.println();
					
			}
			
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
			
		}
		finally {
			DB.closeResultSet();
			DB.closeStatement();

		}
		
	}
	
	
	@Override
	public void inserirLogPositivo(int quantidade, int id_medicamento, String data) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn= DB.getConnection();
			String planilhaLog= "estoque_medicamento ";
			
			pst = conn.prepareStatement(
					"insert into " + planilhaLog	
					+ "(quantidade, id_medicamento, data_registro) "
					+ "values "
					+ "(?,?,?)",
				pst.RETURN_GENERATED_KEYS);
			pst.setInt(1, quantidade);
			pst.setInt(2, id_medicamento);
			pst.setDate(3, new java.sql.Date(sdf.parse(data).getTime()));
			
			
			System.out.println("Teste ");
			
			int linhasAfetadas = pst.executeUpdate();
			System.out.println("Teste");
			if (linhasAfetadas > 0) {
				rs = pst.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Registro de movimentação de estoque gerado com id: " + id);
				}
			}
			
			
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
	public void inserirLogNegativo(int quantidade, int id_medicamento, String data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn= DB.getConnection();
			String planilhaLog= "estoque_medicamento ";
			
			pst = conn.prepareStatement(
				"insert into " + planilhaLog	
				+ "(quantidade, id_medicamento, data_registro) "
				+ "values "
				+ "(?,?,?)",
				pst.RETURN_GENERATED_KEYS);
			pst.setInt(1, quantidade*-1); 
			pst.setInt(2, id_medicamento);
			pst.setDate(3, new java.sql.Date(sdf.parse(data).getTime()));
			
			
			System.out.println("Teste ");
			
			int linhasAfetadas = pst.executeUpdate();
			System.out.println("Teste");
			if (linhasAfetadas > 0) {
				rs = pst.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Registro de movimentação de estoque gerado com id: " + id);
				}
			}
			
			
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

	public void validarRetiradaEstoque(int medicamento_id) {
		
		
	}

	@Override
	public void validarRetiradaEstoque() {
		// TODO Auto-generated method stub
		
	}
	
}


