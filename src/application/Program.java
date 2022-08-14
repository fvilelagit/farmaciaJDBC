package application;

import dao.ClienteDao;
import dao.DaoFabrica;
import dao.MedicamentoDao;
import dao.RepositorioDao;

public class Program {

	public static void main(String [] args) {
//		RegistroDao rDao = DaoFabrica.criarRegistroDao();
//		RepositorioDao repDao = DaoFabrica.criarRepositorioDao();	
//		MedicamentoDao mDao = DaoFabrica.criarMedicamentoDao();	
//		
//		mDao.deletarPorId(8);

		ClienteDao cDao = DaoFabrica.criarClienteDao();
		
		cDao.deletarPorId(3);
		
//		
//		cDao.inserirCliente("Luquinhas Porradão", "123456789", "7188787877", "04/04/1994");
		
//		cDao.atualizarCliente(3, "Marquito da galera", "0235681585", "71717458256","05/05/1995");
		
	
//		repDao.adicionarMedicamentoEstoque(10, 2);
			
		
//		rDao.inserirRegistro("2022/08/15", 5, 2, "897419863");
		
//		rDao.buscarPorCliente("78941352");
//		

//		
//		System.out.println(mDao.buscarPorId(2).toString());
//		
//		Double d = Math.pow(10, 44);
//		d.toString();
//		
//		System.out.println(d);
//		
	}
	
}