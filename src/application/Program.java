package application;

import javax.swing.JOptionPane;

import dao.ClienteDao;
import dao.DaoFabrica;
import db.DB;
import interfaces.MenuPrincipal;

public class Program {

	public static void main(String [] args) {
		try {
			DB.getConnection();
			MenuPrincipal tela = new MenuPrincipal();
			tela.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro" + e);
		}
		
//		RepositorioDao repDao = DaoFabrica.criarRepositorioDao();
		ClienteDao cDao = DaoFabrica.criarClienteDao();
		
//		cDao.inserirCliente("Luquinhas Porrad�o", "123456789", "7188787877", "04/04/1994");
		
		cDao.exibirClientes();
		
//		RegistroDao rDao = DaoFabrica.criarRegistroDao();	
//		repDao.adicionarMedicamentoEstoque(10, 2);
			
		
//		rDao.inserirRegistro("2022/08/15", 5, 2, "897419863");
		
//		rDao.buscarPorCliente("78941352");
//		
//		MedicamentoDao mDao = DaoFabrica.criarMedicamentoDao();
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