package util.enums;

public enum Pagamento {

	CREDITO("Crédito"),
	DEBITO("Débito"),
	A_VISTA("A vista");
	
	
	private String descricao;
	
	Pagamento(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
}
