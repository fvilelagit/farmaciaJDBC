package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.RepositorioDao;
import db.DB;
import db.DbException;

public class RepositorioDaoJDBC implements RepositorioDao{

	private Connection conn;
	public RepositorioDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public void adicionarMedicamentoEstoque(int qtd, int id_medicamento) {
		PreparedStatement pst = null;
		ResultSet rs =null;
			try {
				conn = DB.getConnection();
				pst = conn.prepareStatement(
						"insert into estoque_medicamento"
						+"(quantidade, id_medicamento) "
						+ "values "
						+ "(?,?) ;",
						pst.RETURN_GENERATED_KEYS);		
				pst.setInt(1, qtd);
				pst.setInt(2, id_medicamento);
				
				int linhasAfetadas = pst.executeUpdate();
				rs = pst.getGeneratedKeys();
				if (linhasAfetadas > 0)
					while(rs.next()) {
						int id = rs.getInt(1);
						System.out.println("Registro em banco de estoque de ID " + id);
						System.out.printf("Medicamento de id: %d adicionado. ",id_medicamento);
						System.out.println("");
						System.out.printf("+ %d unidades adicionada(s). ",qtd);
					}			
						
			}catch (SQLException e) {
				throw new DbException (e.getMessage());
			}
			finally {
				DB.closeResultSet();
				DB.closeStatement();
				DB.closeConnection();
			}
	}
	
	

	@Override
	public void atualizarEstoque(int qtd, int id_medicamento) {
		PreparedStatement pst = null;
		ResultSet rs =null;
			try {
				conn = DB.getConnection();
				pst = conn.prepareStatement(
					"UPDATE estoque_medicamento "
					+"SET quantidade = ? WHERE id_medicamento = ? ;"
					);
				pst.setInt(1, qtd);
				pst.setInt(2, id_medicamento);
				pst.executeUpdate();
				
				int linhasAfetadas = pst.executeUpdate();
				if (linhasAfetadas > 0) {
					System.out.printf("Saldo em estoque do id: %d atualizado.",id_medicamento);
					System.out.println();
					System.out.printf("Saldo atual: %d ",qtd);
				}			
				
						
			}catch (SQLException e) {
				throw new DbException (e.getMessage());
			}
			finally {
				DB.closeResultSet();
				DB.closeStatement();
				DB.closeConnection();
			}

	}
		
	
}
