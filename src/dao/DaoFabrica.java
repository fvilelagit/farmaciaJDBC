package dao;

import dao.impl.ClienteDaoJDBC;
import dao.impl.MedicamentoDaoJDBC;
import dao.impl.RegistroDaoJDBC;
import db.DB;

public class DaoFabrica {


	// ClienteDao dao = DaoFabrica.createClienteDao();
	
	
	public static ClienteDao criarClienteDao() {
		return new ClienteDaoJDBC();
	}
	
	public static RegistroDao criarRegistroDao() {
		return new RegistroDaoJDBC(DB.getConnection());
	}
	
	public static MedicamentoDao criarMedicamentoDao() {
		return new MedicamentoDaoJDBC(DB.getConnection());
	}
	
	
}
