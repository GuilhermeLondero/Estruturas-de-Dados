import java.util.ArrayList;

public class Matriz {

    public static void inicializarMatriz(int matriz[][], int qtdL, int qtdC) {
        for (int i = 0; i < qtdL; i++) {
            for (int j = 0; j < qtdC; j++) {
                matriz[i][j] = 0;
            }
        }
    }

    public static void exibirMatriz(int matriz[][], int qtdL, int qtdC) {
        for (int i = 0; i < qtdL; i++) {
            for (int j = 0; j < qtdC; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void converterMatrizEmLista(int matriz[][], int qtdL, int qtdC, ArrayList<Dado> lista) {
        for (int i = 0; i < qtdL; i++) {
            for (int j = 0; j < qtdC; j++) {
                if (matriz[i][j] != 0) {
                    lista.add(new Dado(matriz[i][j], i, j));
                }
            }
        }
    }

    public static void exibirLista(ArrayList<Dado> lista) {
        System.out.println("Valor\tLinha\tColuna");
        for (Dado item : lista) {
            System.out.println(item.valor + "\t" + item.linha + "\t" + item.coluna);
        }
        System.out.println("Total de elementos: " + lista.size());
    }
}