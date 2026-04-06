import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class FichaAtendimento {
    /**
     * Método de classe que gera ficha normal
     * @param filaNormal - Contém fila de fichas normais
     * @param contadorNormal - Contador de fichas normais, utilizado para gerar o número da ficha
     * @return
     */
    public static int geraFichaNormal(Queue<Integer> filaNormal, int contadorNormal) {
        System.out.print("Imprimindo ficha normal.... ");
        System.out.println(contadorNormal);
        filaNormal.offer(contadorNormal);
        contadorNormal++;
        return contadorNormal;
    }

    /**
     * Método de classe que gera ficha prioritaria
     * @param filaPrioritaria - Contém fila de fichas prioritárias
     * @param contadorPrioritario - Contador de fichas prioritárias, utilizado para gerar o número da ficha
     * @return
     */
    public static int geraFichaPrioritaria(Queue<Integer> filaPrioritaria, int contadorPrioritario) {
        System.out.print("Imprimindo ficha prioritaria.... ");
        System.out.println(contadorPrioritario);
        filaPrioritaria.offer(contadorPrioritario);
        contadorPrioritario++;
        return contadorPrioritario;
    }

    /**
     * Método de classe que gera atendimento
     * @param filaNormal - Contém fila de fichas normais
     * @param filaPrioritaria - Contém fila de fichas prioritárias
     * @param contadorAtendimentos - Contador de atendimentos realizados, utilizado para determinar quando chamar ficha prioritária ou normal
     * @return
     */
    public static int geraAtendimento(Queue<Integer> filaNormal, Queue<Integer> filaPrioritaria, int contadorAtendimentos) {
        if (filaNormal.isEmpty() && filaPrioritaria.isEmpty()) {
            System.out.println("Nao ha fichas para chamar");
            return contadorAtendimentos;
        }
        System.out.print("Chamando ficha.... ");
        int ficha;
        if (contadorAtendimentos % 3 == 0 || filaNormal.isEmpty()) {
            //chamar prioritario
            if (!filaPrioritaria.isEmpty()) {
                ficha = filaPrioritaria.poll();
                System.out.println(" PRIORITARIA... "+ ficha);
                contadorAtendimentos++;
                return contadorAtendimentos;
            }
        } 
        if (!filaNormal.isEmpty()) {
            ficha = filaNormal.poll();
            System.out.println(" NORMAL... "+ ficha);
            contadorAtendimentos++;
        }
        return contadorAtendimentos;
    }

    /**
     * Método de classe que mostra fichas faltantes nas filas normal e prioritária
     * @param filaNormal - Contém fila de fichas normais
     * @param filaPrioritaria - Contém fila de fichas prioritárias
     */
    public static void mostraFichasFaltantes(Queue<Integer> filaNormal, Queue<Integer> filaPrioritaria) {
        if (filaNormal.isEmpty() && filaPrioritaria.isEmpty()) {
            System.out.println("Nao ha fichas para chamar");
            return;
        }
        System.out.println("Mostrando fichas faltantes.... ");
        if (!filaNormal.isEmpty()) {
            System.out.println("Total de fichas faltantes NORMAL... " + filaNormal.size() + " - " + filaNormal);
        }
        if (!filaPrioritaria.isEmpty()) {
            System.out.println("Total de fichas faltantes PRIORITARIA... " + filaPrioritaria.size() + " - " + filaPrioritaria);
        }
    }
    
    /**
     * Método de classe que mostra o menu de opções para o usuário
     * @param filaNormal - Contém fila de fichas normais
     * @param filaPrioritaria - Contém fila de fichas prioritárias
     */
    public static void menu(Queue<Integer> filaNormal, Queue<Integer> filaPrioritaria) {
        String opcao = "";
        Scanner teclado = new Scanner(System.in);
        int contadorPrioritario = 501;
        int contadorNormal = 1;
        int contadorAtendimentos = 0; 

        do {
            System.out.println("M E N U");
            System.out.println("1 - Ficha normal");
            System.out.println("2 - Ficha prioritaria");
            System.out.println("3 - Chamar ficha");
            System.out.println("4 - Mostrar fichas faltantes");
            System.out.println("5 - Sair");
            System.out.print("Opcao: ");
            opcao = teclado.nextLine();

            switch (opcao) {
                case "1":
                    contadorNormal = geraFichaNormal(filaNormal, contadorNormal);
                    break;
                case "2":
                    contadorPrioritario = geraFichaPrioritaria(filaPrioritaria, contadorPrioritario);
                    break;
                case "3":
                    contadorAtendimentos = geraAtendimento(filaNormal, filaPrioritaria, contadorAtendimentos);
                    break;
                case "4":
                    if (filaNormal.isEmpty() && filaPrioritaria.isEmpty()) {
                        System.out.println("Nao ha fichas para chamar");
                        break;
                    }
                    System.out.println("Mostrando fichas faltantes.... ");
                    if (!filaNormal.isEmpty()) {
                        System.out.println("Total de fichas faltantes NORMAL... " + filaNormal.size() + " - " + filaNormal);
                    }
                    if (!filaPrioritaria.isEmpty()) {
                        System.out.println("Total de fichas faltantes PRIORITARIA... " + filaPrioritaria.size() + " - " + filaPrioritaria);
                    }
                    break;
                case "5":
                    System.out.println("Obrigado por usar o programa.... ");
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while (!opcao.equals("5"));
    }

    public static void main(String[] args) {
        Queue<Integer> filaNormal = new LinkedList<>();
        Queue<Integer> filaPrioritaria = new LinkedList<>();

        menu(filaNormal, filaPrioritaria);
    }
}
 