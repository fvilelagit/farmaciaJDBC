package repositorio;

public class MedicamentoRepositorio {

	private int id;
	private int quantidade;
	private int idMedicamento;
	
	public MedicamentoRepositorio(int id, int idMedicamento) {
		super();
		this.id = id;
		this.idMedicamento = idMedicamento;
	}

	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(int idMedicamento) {
		this.idMedicamento = idMedicamento;
	}
	

	
}
