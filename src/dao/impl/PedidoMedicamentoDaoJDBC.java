package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import dao.PedidoMedicamentoDao;
import db.DB;
import db.DbException;

public class PedidoMedicamentoDaoJDBC implements PedidoMedicamentoDao {

	private Connection conn;
	public PedidoMedicamentoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	
	
}
