package dao;

import dao.impl.ClienteDaoJDBC;
import dao.impl.LogMedicamentoDaoJDBC;
import dao.impl.MedicamentoDaoJDBC;
import dao.impl.PedidoDaoJDBC;
import dao.impl.PedidoMedicamentoDaoJDBC;
import dao.impl.RegistroDaoJDBC;
import dao.impl.RepositorioDaoJDBC;
import db.DB;

public class DaoFabrica {


	public static RepositorioDao criarRepositorioDao() {
		return new RepositorioDaoJDBC(DB.getConnection());
	}
	
	public static ClienteDao criarClienteDao() {
		return new ClienteDaoJDBC(DB.getConnection());
	}
	
	public static RegistroDao criarRegistroDao() {
		return new RegistroDaoJDBC(DB.getConnection());
	}
	
	public static MedicamentoDao criarMedicamentoDao() {
		return new MedicamentoDaoJDBC(DB.getConnection());
	}
	
	public static LogMedicamentoDao criarLogMedicamentoDao() {
		return new LogMedicamentoDaoJDBC(DB.getConnection());
	}
	
	public static PedidoDao criarPedidoDao() {
		return new PedidoDaoJDBC(DB.getConnection());
	}
	
	public static PedidoMedicamentoDao criarPedidoMedicamentoDao() {
		return new PedidoMedicamentoDaoJDBC(DB.getConnection());
	}
	
	
}
