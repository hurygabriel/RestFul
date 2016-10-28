package enumeration;

/**
 * Constantes de posicao de um jogo, dos jogadores.
 * @author hury
 *
 */
public enum PosicaoJogador {

    ATACANTE("Atacante"), GOLEIRO("Goleiro"),
    LATERALE("Lateral Esquerda"), LATERALD("Lateral Direita"),
    ZAGUEIRO("Zagueiro"), MEIA("Meio Campista"),
    VOLANTE("Volante");

    private String descricao;

    private PosicaoJogador(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

