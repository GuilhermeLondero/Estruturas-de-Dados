import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

/**
 * Responsável por carregar e salvar listas de figurinhas em arquivos CSV.
 * Cada linha do CSV representa uma figurinha no formato:
 * nomeSelecao,numeroFigura,descricao,quantidade,rara
 */
public class GerenciadorCsv {

    /**
     * Lê um arquivo CSV e popula a lista com objetos Figura.
     * Se o arquivo não existir, exibe aviso e encerra sem erro.
     *
     * @param lista       ArrayList de Figura que receberá os dados lidos do arquivo
     * @param nomeArquivo Nome ou caminho do arquivo CSV a ser lido. Ex: "figuras_repetidas_pessoais.csv"
     */
    public static void carregarDeCsv(ArrayList<Figura> lista, String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) {
            System.out.println("Arquivo nao encontrado: " + nomeArquivo);
            return;
        }

        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] campos = linha.split(",");
                String nomeSelecao = campos[0];
                int numeroFigura   = Integer.parseInt(campos[1]);
                String descricao   = campos[2];
                int quantidade     = Integer.parseInt(campos[3]);
                boolean rara       = Boolean.parseBoolean(campos[4]);

                Figura figura = new Figura(nomeSelecao, numeroFigura, descricao, quantidade, rara);

                if (!estaContido(figura, lista)) {
                    lista.add(figura);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    /**
     * Grava todas as figurinhas da lista em um arquivo CSV.
     * Se o arquivo já existir, ele será sobrescrito.
     *
     * @param lista       ArrayList de Figura contendo as figurinhas a serem salvas
     * @param nomeArquivo Nome ou caminho do arquivo CSV de destino. Ex: "figuras_repetidas_pessoais.csv"
     */
    public static void salvarEmCsv(ArrayList<Figura> lista, String nomeArquivo) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Figura figura : lista) {
                escritor.write(figura.toCSV());
                escritor.newLine();
            }
            System.out.println("Arquivo salvo: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    /**
     * Exibe todas as figurinhas da lista no console, uma por linha.
     * Ao final, exibe o total de registros.
     *
     * @param lista ArrayList de Figura contendo as figurinhas a serem exibidas
     */
    public static void exibirLista(ArrayList<Figura> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhuma figurinha cadastrada.");
            return;
        }
        for (Figura figura : lista) {
            System.out.println(figura);
        }
        System.out.println("---------------------------------");
        System.out.println("Total de registros: " + lista.size());
    }

    /**
     * Verifica se uma figurinha já está presente na lista, usando o equals de Figura
     * (comparação por nomeSelecao + numeroFigura).
     *
     * @param figura Figura a ser pesquisada na lista
     * @param lista  ArrayList de Figura onde a busca será realizada
     * @return true se a figurinha já estiver na lista, false caso contrário
     */
    public static boolean estaContido(Figura figura, ArrayList<Figura> lista) {
        for (Figura item : lista) {
            if (item.equals(figura)) {
                return true;
            }
        }
        return false;
    }
}