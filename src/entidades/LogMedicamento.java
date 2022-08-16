package entidades;

import java.io.Serializable;
import java.util.Date;

public class LogMedicamento implements Serializable {

	private int id;
	private int id_medicamento;
	private Date data;
	
	
	public LogMedicamento() {
		super();
	}

	public LogMedicamento(int id, int id_medicamento, Date data) {
		super();
		this.id = id;
		this.id_medicamento = id_medicamento;
		this.data = data;
	}
	
	public LogMedicamento(int id, int id_medicamento) {
		super();
		this.id = id;
		this.id_medicamento = id_medicamento;

	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_medicamento() {
		return id_medicamento;
	}

	public void setId_medicamento(int id_medicamento) {
		this.id_medicamento = id_medicamento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	
	
	
}
