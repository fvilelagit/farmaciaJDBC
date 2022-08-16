package application;

import java.util.Scanner;

import dao.DaoFabrica;
import dao.LogMedicamentoDao;
import dao.PedidoDao;
import dao.PedidoMedicamentoDao;

public class BackEndTest {

	public static void main(String[] args) {

//		RegistroDao rDao = DaoFabrica.criarRegistroDao();
//		RepositorioDao repDao = DaoFabrica.criarRepositorioDao();	
//		MedicamentoDao mDao = DaoFabrica.criarMedicamentoDao();
//
//		repDao.adicionarMedicamentoEstoque(30, 2);
//		LogMedicamentoDao LogMDao= DaoFabrica.criarLogMedicamentoDao();
//		
//		LogMDao.inserirLogPositivo(15, 2, "25/04/2022");
//		
//		LogMDao.inserirLogNegativo(4, 1, "25/04/2020");
//		LogMDao.exibirEstoqueTotal();
//		
//		
//		
//		mDao.deletarPorId(8);
//		ClienteDao cDao = DaoFabrica.criarClienteDao();
//		
//		cDao.deletarPorId(3);
//		
//		cDao.inserirCliente("Luquinhas Porradão", "123456789", "7188787877", "04/04/1994");
//		RepositorioDao repDao = DaoFabrica.criarRepositorioDao();
//		ClienteDao cDao = DaoFabrica.criarClienteDao();
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

		
		
		
		
//		Scanner sc = new Scanner(System.in);
//
//		boolean continua;
//
//		PedidoMedicamentoDao pmDao = DaoFabrica.criarPedidoMedicamentoDao();
//		PedidoDao pDao = DaoFabrica.criarPedidoDao();
////
//		pDao.consultaQtd(3);
		
		
//		System.out.println("Vamo la");
//		do {
//			int qtdMedicamento = sc.nextInt();
//			int idMedicamento = sc.nextInt();
//
//			pDao.novoMedicamento(qtdMedicamento, idMedicamento);
//
//			System.out.println("VAi?");
//			String c = sc.next();
//			if (c.charAt(0) == 's') {
//				continua = true;
//			} else {
//				continua = false;
//			}
//
//		} while (continua == true);

		PedidoDao pDao = DaoFabrica.criarPedidoDao();
		
		pDao.inserirPedido("01/04/2000",10,2,"123456789","Credito" );
	
	
	
	}

}
