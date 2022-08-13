package entidades;

public class Medicamento {

	private Long id;
	private String nome;
	private String marca;
	private Double valor;
	private boolean generico;
	private boolean remedio;

	public Medicamento() {
		super();
	}

	public Medicamento(Long id, String nome, String marca, Double valor, boolean generico,
			boolean remedio) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.valor = valor;
		this.generico = generico;

	}

	@SuppressWarnings("unused")
	private double calculoValorGenerico(Double valor, Boolean generico) {
		if (generico == true) {
			valor = this.valor - (this.valor * 0.2);
			return valor;
		}else {
			return this.valor;
		}
			
	}
	
	
	
	public boolean isGenerico() {
		return generico;
	}

	public void setGenerico(boolean generico) {
		this.generico = generico;
	}

	public boolean isRemedio() {
		return remedio;
	}

	public void setRemedio(boolean remedio) {
		this.remedio = remedio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	

	@Override
	public String toString() {
		return "Medicamento [id=" + id + ", nome=" + nome + ", marca=" + marca + ", valor=" + valor + ", generico="
				+ generico + ", remedio=" + remedio + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
	
}
