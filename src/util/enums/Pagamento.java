package util.enums;

public enum Pagamento {

	CREDITO("Cr�dito"),
	DEBITO("D�bito"),
	A_VISTA("A vista");
	
	
	private String descricao;
	
	Pagamento(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
}
