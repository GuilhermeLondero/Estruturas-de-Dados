/**
 * Representa uma figurinha do album da Copa do Mundo.
 *
 * Atributos:
 *     nomeSelecao - Nome da selecao a qual a figurinha pertence. Ex: "Brasil", "Argentina"
 *     numeroFigura - Numero identificador da figurinha dentro do album
 *     descricao - Descricao do conteudo da figurinha. Ex: nome do jogador ou da selecao
 *     quantidade - Quantidade de copias dessa figurinha disponiveis
 *     rara - Indica se a figurinha e do tipo rara (true) ou comum (false)
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
     * @param nomeSelecao  Nome da selecao. Ex: "Brasil", "Franca"
     * @param numeroFigura Numero identificador da figurinha no album
     * @param descricao    Descricao do conteudo da figurinha
     * @param quantidade   Quantidade de copias dessa figurinha
     * @param rara         true se a figurinha for rara, false se for comum
     */
    public Figura(String nomeSelecao, int numeroFigura, String descricao, int quantidade, boolean rara) {
        this.nomeSelecao = nomeSelecao;
        this.numeroFigura = numeroFigura;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.rara = rara;
    }

    /**
     * Compara duas figurinhas com base na selecao e no numero da figurinha.
     *
     * @param obj Objeto a ser comparado com a figurinha atual
     * @return true se nomeSelecao e numeroFigura forem iguais, false caso contrario
     */
    public boolean equals(Object obj) {
        if (obj instanceof Figura) {
            Figura outra = (Figura) obj;
            return this.numeroFigura == outra.numeroFigura &&
                   this.nomeSelecao.equals(outra.nomeSelecao);
        }
        return false;
    }

    /**
     * Retorna uma representacao em texto da figurinha.
     *
     * @return String formatada com os dados da figurinha
     */
    public String toString() {
        String tipo;
        if (rara) {
            tipo = "RARA";
        } else {
            tipo = "comum";
        }
        return "[" + nomeSelecao + " #" + numeroFigura + "] " + descricao +
               " | Qtd: " + quantidade + " | " + tipo;
    }

    /**
     * Converte a figurinha em uma linha no formato CSV.
     *
     * @return String no formato: nomeSelecao,numeroFigura,descricao,quantidade,rara
     */
    public String toCSV() {
        return nomeSelecao + "," + numeroFigura + "," + descricao + "," + quantidade + "," + rara;
    }

    public String getNomeSelecao() {
        return nomeSelecao;
    }

    public void setNomeSelecao(String nomeSelecao) {
        this.nomeSelecao = nomeSelecao;
    }

    public int getNumeroFigura() {
        return numeroFigura;
    }

    public void setNumeroFigura(int numeroFigura) {
        this.numeroFigura = numeroFigura;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isRara() {
        return rara;
    }

    public void setRara(boolean rara) {
        this.rara = rara;
    }
}