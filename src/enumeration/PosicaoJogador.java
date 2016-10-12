package enumeration;

public enum PosicaoJogador {

    ATACANTE("Atacante"), GOLEIRO("Goleiro");

    private String descricao;

    private PosicaoJogador(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

