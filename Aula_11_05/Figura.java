/**
 * Representa uma figurinha do álbum da Copa do Mundo.
 *
 * Atributos:
 *     nomeSelecao  - Nome da seleção à qual a figurinha pertence. Ex: "Brasil", "Argentina"
 *     numeroFigura - Número identificador da figurinha dentro do álbum
 *     descricao    - Descrição do conteúdo da figurinha. Ex: nome do jogador ou da seleção
 *     quantidade   - Quantidade de cópias dessa figurinha disponíveis
 *     rara         - Indica se a figurinha é do tipo rara (true) ou comum (false)
 */
public class Figura {

    private String nomeSelecao;
    private int numeroFigura;
    private String descricao;
    private int quantidade;
    private boolean rara;

    /**
     * Construtor da classe Figura.
     *
     * @param nomeSelecao  Nome da seleção à qual a figurinha pertence. Ex: "Brasil", "França"
     * @param numeroFigura Número identificador da figurinha dentro do álbum
     * @param descricao    Descrição do conteúdo da figurinha. Ex: nome do jogador ou da seleção
     * @param quantidade   Quantidade de cópias dessa figurinha disponíveis
     * @param rara         Indica se a figurinha é do tipo rara (true) ou comum (false)
     */
    public Figura(String nomeSelecao, int numeroFigura, String descricao, int quantidade, boolean rara) {
        this.nomeSelecao = nomeSelecao;
        this.numeroFigura = numeroFigura;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.rara = rara;
    }

    /**
     * Verifica se duas figurinhas são iguais com base na seleção e no número da figurinha.
     * Dois objetos Figura são considerados iguais se tiverem o mesmo nomeSelecao e numeroFigura.
     *
     * @param obj Objeto a ser comparado com a figurinha atual
     * @return true se nomeSelecao e numeroFigura forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Figura outra = (Figura) obj;
        return this.numeroFigura == outra.numeroFigura &&
               this.nomeSelecao.equalsIgnoreCase(outra.nomeSelecao);
    }

    /**
     * Retorna uma representação textual da figurinha para exibição no console.
     * Formato: [nomeSelecao #numeroFigura] descricao | Qtd: quantidade | rara/comum
     *
     * @return String formatada com os dados da figurinha
     */
    @Override
    public String toString() {
        String tipoRara = rara ? "RARA" : "comum";
        return "[" + nomeSelecao + " #" + numeroFigura + "] " +
               descricao + " | Qtd: " + quantidade + " | " + tipoRara;
    }

    /**
     * Converte a figurinha em uma linha no formato CSV para gravação em arquivo.
     * Formato gerado: nomeSelecao,numeroFigura,descricao,quantidade,rara
     *
     * @return String no formato CSV representando a figurinha
     */
    public String toCSV() {
        return nomeSelecao + "," + numeroFigura + "," + descricao + "," + quantidade + "," + rara;
    }

    // -------------------------
    // Getters e Setters
    // -------------------------

    /**
     * @return Nome da seleção da figurinha
     */
    public String getNomeSelecao() {
        return nomeSelecao;
    }

    /**
     * @param nomeSelecao Nome da seleção a ser atribuído. Ex: "Brasil", "França"
     */
    public void setNomeSelecao(String nomeSelecao) {
        this.nomeSelecao = nomeSelecao;
    }

    /**
     * @return Número identificador da figurinha no álbum
     */
    public int getNumeroFigura() {
        return numeroFigura;
    }

    /**
     * @param numeroFigura Número inteiro a ser atribuído
     */
    public void setNumeroFigura(int numeroFigura) {
        this.numeroFigura = numeroFigura;
    }

    /**
     * @return Descrição da figurinha
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao Texto descritivo da figurinha. Ex: nome do jogador
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return Quantidade de cópias disponíveis dessa figurinha
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade Número inteiro de cópias a ser atribuído
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return true se a figurinha é rara, false se é comum
     */
    public boolean isRara() {
        return rara;
    }

    /**
     * @param rara true para rara, false para comum
     */
    public void setRara(boolean rara) {
        this.rara = rara;
    }
}