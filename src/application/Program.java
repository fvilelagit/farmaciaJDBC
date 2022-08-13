package application;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import dao.DaoFabrica;
import dao.MedicamentoDao;
import dao.RegistroDao;

public class Program {

	public static void main(String [] args) {
		
		RegistroDao rDao = DaoFabrica.criarRegistroDao();
		
		rDao.buscarPorCliente("78941352");
		
//		MedicamentoDao mDao = DaoFabrica.criarMedicamentoDao();
//		
//		System.out.println(mDao.buscarPorId(2).toString());
//		
//		Double d = Math.pow(10, 44);
//		d.toString();
//		
//		System.out.println(d);
		
	}
	
}