package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.MedicamentoDao;
import db.DB;
import db.DbException;
import entidades.Medicamento;

public class MedicamentoDaoJDBC implements MedicamentoDao{

	private Connection conn;
	
	public MedicamentoDaoJDBC(Connection conn){
		this.conn = conn;
	}
	
	@Override
	public void inserirMedicamento(Medicamento m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarMedicamento(Medicamento m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarPorId(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Medicamento buscarPorId(int id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(
					"SELECT * FROM medicamento "
					+"WHERE id=?"
					);
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
		
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet();
			DB.closeStatement();
			DB.closeConnection();
		}
		
		
		
	}
	
	@Override
	public List<Medicamento> listarMedicamentos() {
		// TODO Auto-generated method stub
		return null;
	}

}
