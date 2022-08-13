package servicos.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import servicos.PedidoServico;

public class PedidoServicoIMPL implements PedidoServico {

	public final String gerarNf() {
		String n = "01234567890123456789012345678901234567890147";
		List<String> numero = Arrays.asList(n.split(""));
		Collections.shuffle(numero);
		StringBuilder t = new StringBuilder(n.length());
		for (String k : numero) {
			t.append(k);
		}
		return t.toString();
	}
	
	
	
	
	
}
