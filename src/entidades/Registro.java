package entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class Registro implements Serializable{
	
	private Long id;
	private Date moment;
	private Double valorTotal;
	private int qtdMedicamento;
	private String numeroNf;

	private Cliente cliente;
	private Medicamento medicamento;
	
	public Registro() {
		super();
	}
	
	public Registro(Long id, Double valorTotal, int qtdMedicamento, Medicamento medicamento, Cliente cliente) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.medicamento = medicamento;
		this.valorTotal = valorTotal;
	}


	public Registro(Long id,Double valorTotal, Medicamento medicamento, Cliente cliente, Date moment, String numeroNf) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.medicamento = medicamento;
		this.moment = moment;
		this.valorTotal = valorTotal;
		this.numeroNf = numeroNf; //método pra gerar nf aleatoria
	}
	
	
	
	public int getQtdMedicamento() {
		return qtdMedicamento;
	}

	public void setQtdMedicamento(int qtdMedicamento) {
		this.qtdMedicamento = qtdMedicamento;
	}

	public String getNumeroNf() {
		return numeroNf;
	}

	public void setNumeroNf(String numeroNf) {
		this.numeroNf = numeroNf;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Date getMoment() {
		return moment;
	}


	public void setMoment(Date moment) {
		this.moment = moment;
	}


	public Double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public static final String gerarNf() {
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
