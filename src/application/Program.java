package application;

import dao.DaoFabrica;
import dao.LogMedicamentoDao;
import interfaces.TelaEntrada;

//
//import javax.swing.JOptionPane;
//
//import dao.ClienteDao;
//import dao.DaoFabrica;
//<<<<<<< HEAD
//import dao.MedicamentoDao;
//import dao.RepositorioDao;
//=======
//import db.DB;
//import interfaces.MenuPrincipal;
//>>>>>>> 13095dca7fe303156c1c7c7b496926582ce39f2d
//
public class Program {

	public static void main(String [] args) {
//<<<<<<< HEAD
			LogMedicamentoDao lm = DaoFabrica.criarLogMedicamentoDao();
//			lm.inserirLogPositivo(50, 7, "15/08/2022");
//			lm.inserirLogPositivo(50, 5, "16/08/2022");
			lm.exibirEstoqueTotal();
			TelaEntrada tela = new TelaEntrada();
			tela.setVisible(true);
			
////		RegistroDao rDao = DaoFabrica.criarRegistroDao();
////		RepositorioDao repDao = DaoFabrica.criarRepositorioDao();	
////		MedicamentoDao mDao = DaoFabrica.criarMedicamentoDao();	
////		
////		mDao.deletarPorId(8);
//
//		ClienteDao cDao = DaoFabrica.criarClienteDao();
//		
//		cDao.deletarPorId(3);
//		
////		
////		cDao.inserirCliente("Luquinhas Porrad�o", "123456789", "7188787877", "04/04/1994");
//=======
//		try {
//			DB.getConnection();
//			MenuPrincipal tela = new MenuPrincipal();
//			tela.setVisible(true);
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "Erro" + e);
//		}
//		
////		RepositorioDao repDao = DaoFabrica.criarRepositorioDao();
//		ClienteDao cDao = DaoFabrica.criarClienteDao();
//		
////		cDao.inserirCliente("Luquinhas Porrad�o", "123456789", "7188787877", "04/04/1994");
//>>>>>>> 13095dca7fe303156c1c7c7b496926582ce39f2d
//		
////		cDao.atualizarCliente(3, "Marquito da galera", "0235681585", "71717458256","05/05/1995");
//		
//	
////		repDao.adicionarMedicamentoEstoque(10, 2);
//			
//		
////		rDao.inserirRegistro("2022/08/15", 5, 2, "897419863");
//		
////		rDao.buscarPorCliente("78941352");
////		
//
////		
////		System.out.println(mDao.buscarPorId(2).toString());
////		
////		Double d = Math.pow(10, 44);
////		d.toString();
////		
////		System.out.println(d);
////		
	}
	
}