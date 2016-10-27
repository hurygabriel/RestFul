package enumeration;

public enum Posto {

	TITULAR("Titular"), RESERVA("Reserva");
	
    private String descricao;

    private Posto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
