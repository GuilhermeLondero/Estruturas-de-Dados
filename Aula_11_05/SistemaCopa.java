import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principal do sistema de gerenciamento de figurinhas da Copa 2026.
 * Controla o menu, o cadastro, a listagem e a lógica de match para trocas.
 *
 * Listas utilizadas:
 *     lista_repetidas_pessoais - Figurinhas repetidas do usuário
 *     lista_desejadas_pessoais - Figurinhas desejadas pelo usuário
 *     lista_repetidas_outro    - Figurinhas repetidas de outra pessoa (carregadas por arquivo)
 *     lista_desejadas_outro    - Figurinhas desejadas de outra pessoa (carregadas por arquivo)
 *
 * Arquivos CSV pessoais (carregados automaticamente ao iniciar):
 *     figuras_repetidas_pessoais.csv
 *     figuras_desejadas_pessoais.csv
 */
public class SistemaCopa {

    static String ARQUIVO_REPETIDAS_PESSOAIS = "figuras_repetidas_pessoais.csv";
    static String ARQUIVO_DESEJADAS_PESSOAIS = "figuras_desejadas_pessoais.csv";

    /**
     * Solicita os dados de uma figurinha ao usuário, cria o objeto Figura,
     * adiciona na lista e persiste no arquivo CSV correspondente.
     *
     * @param lista       ArrayList de Figura onde a nova figurinha será adicionada
     * @param nomeArquivo Nome do arquivo CSV onde a figurinha será salva
     * @param teclado     Scanner utilizado para leitura das entradas do usuário
     */
    public static void cadastrarFigura(ArrayList<Figura> lista, String nomeArquivo, Scanner teclado) {
        System.out.print("Nome da selecao: ");
        String nomeSelecao = teclado.nextLine();

        System.out.print("Numero da figurinha: ");
        int numeroFigura = Integer.parseInt(teclado.nextLine());

        System.out.print("Descricao (jogador, brasao ou bandeira): ");
        String descricao = teclado.nextLine();

        System.out.print("Quantidade: ");
        int quantidade = Integer.parseInt(teclado.nextLine());

        System.out.print("E rara? (true/false): ");
        boolean rara = Boolean.parseBoolean(teclado.nextLine());

        Figura figura = new Figura(nomeSelecao, numeroFigura, descricao, quantidade, rara);

        if (GerenciadorCsv.estaContido(figura, lista)) {
            System.out.println("Figurinha ja cadastrada na lista.");
            return;
        }

        lista.add(figura);
        GerenciadorCsv.salvarEmCsv(lista, nomeArquivo);
        System.out.println("Figurinha cadastrada com sucesso!");
    }

    /**
     * Solicita o caminho de um arquivo CSV de outra pessoa, carrega as figurinhas,
     * exibe a lista completa e em seguida exibe as figurinhas que dão match
     * com a lista pessoal fornecida.
     *
     * @param listaOutro        ArrayList de Figura que receberá as figurinhas carregadas do arquivo
     * @param listaMatchPessoal ArrayList de Figura pessoal usada para identificar matches
     * @param teclado           Scanner utilizado para leitura do caminho do arquivo
     */
    public static void carregarEExibirOutro(ArrayList<Figura> listaOutro, ArrayList<Figura> listaMatchPessoal, Scanner teclado) {
        listaOutro.clear();

        System.out.print("Caminho do arquivo CSV: ");
        String caminhoArquivo = teclado.nextLine();

        GerenciadorCsv.carregarDeCsv(listaOutro, caminhoArquivo);

        System.out.println("\n--- Figurinhas carregadas ---");
        GerenciadorCsv.exibirLista(listaOutro);

        System.out.println("\n--- Matches para troca ---");
        exibirMatches(listaOutro, listaMatchPessoal);
    }

    /**
     * Compara duas listas de figurinhas e exibe as que aparecem em ambas,
     * ou seja, as figurinhas que podem ser trocadas entre as duas pessoas.
     *
     * @param listaOutro   ArrayList de Figura de outra pessoa (repetidas ou desejadas)
     * @param listaPessoal ArrayList de Figura pessoal correspondente para comparação
     */
    public static void exibirMatches(ArrayList<Figura> listaOutro, ArrayList<Figura> listaPessoal) {
        int totalMatches = 0;

        for (Figura figura : listaOutro) {
            if (GerenciadorCsv.estaContido(figura, listaPessoal)) {
                System.out.println(figura);
                totalMatches++;
            }
        }

        if (totalMatches == 0) {
            System.out.println("Nenhum match encontrado.");
        } else {
            System.out.println("---------------------------------");
            System.out.println("Total de matches: " + totalMatches);
        }
    }

    /**
     * Exibe o menu principal e processa as opções escolhidas pelo usuário.
     *
     * @param lista_repetidas_pessoais ArrayList de Figura com as repetidas do usuário
     * @param lista_desejadas_pessoais ArrayList de Figura com as desejadas do usuário
     * @param lista_repetidas_outro    ArrayList de Figura com as repetidas de outra pessoa
     * @param lista_desejadas_outro    ArrayList de Figura com as desejadas de outra pessoa
     */
    public static void menu(
        ArrayList<Figura> lista_repetidas_pessoais,
        ArrayList<Figura> lista_desejadas_pessoais,
        ArrayList<Figura> lista_repetidas_outro,
        ArrayList<Figura> lista_desejadas_outro
    ) {
        Scanner teclado = new Scanner(System.in);
        String opcao = "";

        do {
            System.out.println("\n========= SISTEMA DE FIGURINHAS COPA 2026 =========");
            System.out.println("1 - Cadastrar figurinhas repetidas pessoais");
            System.out.println("2 - Listar figurinhas repetidas pessoais");
            System.out.println("3 - Cadastrar figurinhas desejadas pessoais");
            System.out.println("4 - Listar figurinhas desejadas pessoais");
            System.out.println("5 - Carregar figurinhas repetidas OUTRO (+ match com desejadas)");
            System.out.println("6 - Carregar figurinhas desejadas OUTRO (+ match com repetidas)");
            System.out.println("7 - Sair");
            System.out.print("Opcao: ");
            opcao = teclado.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarFigura(lista_repetidas_pessoais, ARQUIVO_REPETIDAS_PESSOAIS, teclado);
                    break;
                case "2":
                    System.out.println("\n--- Figurinhas repetidas pessoais ---");
                    GerenciadorCsv.exibirLista(lista_repetidas_pessoais);
                    break;
                case "3":
                    cadastrarFigura(lista_desejadas_pessoais, ARQUIVO_DESEJADAS_PESSOAIS, teclado);
                    break;
                case "4":
                    System.out.println("\n--- Figurinhas desejadas pessoais ---");
                    GerenciadorCsv.exibirLista(lista_desejadas_pessoais);
                    break;
                case "5":
                    carregarEExibirOutro(lista_repetidas_outro, lista_desejadas_pessoais, teclado);
                    break;
                case "6":
                    carregarEExibirOutro(lista_desejadas_outro, lista_repetidas_pessoais, teclado);
                    break;
                case "7":
                    System.out.println("Encerrando o sistema... Ate logo!");
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while (!opcao.equals("7"));
    }

    /**
     * Ponto de entrada do programa.
     * Inicializa as quatro listas, carrega os CSVs pessoais automaticamente
     * e inicia o menu principal.
     *
     * @param args Argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        ArrayList<Figura> lista_repetidas_pessoais = new ArrayList<>();
        ArrayList<Figura> lista_desejadas_pessoais = new ArrayList<>();
        ArrayList<Figura> lista_repetidas_outro    = new ArrayList<>();
        ArrayList<Figura> lista_desejadas_outro    = new ArrayList<>();

        System.out.println("Carregando dados pessoais...");
        GerenciadorCsv.carregarDeCsv(lista_repetidas_pessoais, ARQUIVO_REPETIDAS_PESSOAIS);
        GerenciadorCsv.carregarDeCsv(lista_desejadas_pessoais, ARQUIVO_DESEJADAS_PESSOAIS);

        menu(lista_repetidas_pessoais, lista_desejadas_pessoais, lista_repetidas_outro, lista_desejadas_outro);
    }
}