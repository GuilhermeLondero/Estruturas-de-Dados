public class Dado {
    public int valor;
    public int linha;
    public int coluna;

    public Dado(int valor, int linha, int coluna) {
        this.valor = valor;
        this.linha = linha;
        this.coluna = coluna;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dado other = (Dado) obj;
        if (this.linha != other.linha) {
            return false;
        }
        return this.coluna == other.coluna;
    }

}