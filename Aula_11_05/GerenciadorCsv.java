import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

/**
 * Classe responsavel por carregar e salvar listas de figurinhas em arquivos CSV.
 * Cada linha do CSV representa uma figurinha no formato:
 * nomeSelecao,numeroFigura,descricao,quantidade,rara
 */
public class GerenciadorCsv {

    /**
     * Le um arquivo CSV e adiciona os objetos Figura na lista informada.
     *
     * @param lista ArrayList de Figura que recebera os dados lidos do arquivo
     * @param nomeArquivo Nome do arquivo CSV a ser lido
     */
    public static void carregarDeCsv(ArrayList<Figura> lista, String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) {
            System.out.println("Arquivo nao encontrado: " + nomeArquivo);
            return;
        }

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha = leitor.readLine();
            while (linha != null) {
                String[] campos = linha.split(",");
                String nomeSelecao = campos[0];
                int numeroFigura = Integer.parseInt(campos[1]);
                String descricao = campos[2];
                int quantidade = Integer.parseInt(campos[3]);
                boolean rara = Boolean.parseBoolean(campos[4]);

                Figura figura = new Figura(nomeSelecao, numeroFigura, descricao, quantidade, rara);

                if (!estaContido(figura, lista)) {
                    lista.add(figura);
                }
                linha = leitor.readLine();
            }
            leitor.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    /**
     * Salva todas as figurinhas da lista em um arquivo CSV.
     *
     * @param lista ArrayList de Figura contendo as figurinhas a serem salvas
     * @param nomeArquivo Nome do arquivo CSV de destino
     */
    public static void salvarEmCsv(ArrayList<Figura> lista, String nomeArquivo) {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo));
            for (Figura figura : lista) {
                escritor.write(figura.toCSV());
                escritor.newLine();
            }
            escritor.close();
            System.out.println("Arquivo salvo: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    /**
     * Exibe todas as figurinhas da lista no console.
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
        System.out.println("Total de registros: " + lista.size());
    }

    /**
     * Verifica se uma figurinha ja esta presente na lista.
     *
     * @param figura Figura a ser pesquisada na lista
     * @param lista ArrayList de Figura onde a busca sera realizada
     * @return true se a figurinha ja estiver na lista, false caso contrario
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