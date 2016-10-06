package enumeration;

public enum SituacaoJuiz {

	DISPONIVEL("Disponivel"), 
	SUSPENSO("Suspenso - devido a punição pelo STJD");
	
	private String descricao;

	private SituacaoJuiz(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	
}
