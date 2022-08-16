package entidades;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import util.enums.Pagamento;

public class Pedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Date moment; //date.now()
	private int qtdMedicamento;
	private Double valorTotal;
	private boolean pago;
	private Pagamento tipoPagamento;
	
	private Long numeroNf;

	private Cliente cliente ;
	private List<Medicamento> medicamento;
	

	public Pedido() {
		super();
	}
	
	public Pedido(int id) {
		this.id = id;
	}


	public Pedido(int id, Date moment, int qtdMedicamento, Double valorTotal, boolean pago, 
			 Cliente cliente, List<Medicamento> medicamento) {
		super();
		this.id = id;
		this.moment = moment;
		this.qtdMedicamento = qtdMedicamento;
		this.valorTotal = valorTotal;
		this.pago = pago;
		this.cliente = cliente;
		this.medicamento = medicamento;
	}
	
	
	public Pedido(int id, Date moment, int qtdMedicamento, Double valorTotal, boolean pago, Pagamento tipoPagamento,
			Long numeroNf, Cliente cliente, List<Medicamento> medicamento) {
		super();
		this.id = id;
		this.moment = moment;
		this.qtdMedicamento = qtdMedicamento;
		this.valorTotal = valorTotal;
		this.pago = pago;
		this.tipoPagamento = tipoPagamento;
		this.numeroNf = numeroNf;
		this.cliente = cliente;
		this.medicamento = medicamento;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public int getQtdMedicamento() {
		return qtdMedicamento;
	}
	public void setQtdMedicamento(int qtdMedicamento) {
		this.qtdMedicamento = qtdMedicamento;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public boolean isPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
	}
	public Pagamento getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(Pagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	public Long getNumeroNf() {
		return numeroNf;
	}
	public void setNumeroNf(Long numeroNf) {
		this.numeroNf = numeroNf;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void adicionarMedicamento(Medicamento m) {
		this.medicamento.add(m);
	}
	
	public void excluirMedicamento(String nomeMedicamento) {
		List<Medicamento> m = this.medicamento;
		for(Medicamento m1 : this.medicamento) {
			if(m1.getNome().equalsIgnoreCase(nomeMedicamento))
				this.medicamento.remove(m1);
		}
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
	

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", moment=" + moment + ", qtdMedicamento=" + qtdMedicamento + ", valorTotal="
				+ valorTotal + ", pago=" + pago + ", tipoPagamento=" + tipoPagamento + ", numeroNf=" + numeroNf
				+ ", cliente=" + cliente + ", medicamentos=" + medicamento + "]";
	}
	

	
	
}
