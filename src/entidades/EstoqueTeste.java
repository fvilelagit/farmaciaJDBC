package entidades;

public class EstoqueTeste {

	private int quantidade;
	private int id_medicamento;
	
	public EstoqueTeste(int quantidade, int id_medicamento) {
		super();
		this.quantidade = quantidade;
		this.id_medicamento = id_medicamento;
	}

	public EstoqueTeste() {
		super();
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getId_medicamento() {
		return id_medicamento;
	}

	public void setId_medicamento(int id_medicamento) {
		this.id_medicamento = id_medicamento;
	}

	
	
}
