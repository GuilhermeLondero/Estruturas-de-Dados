import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        // simulando uma matriz especial
        int dimensao = 10;
        int matriz[][] = new int[dimensao][dimensao];
        Matriz.inicializarMatriz(matriz, dimensao, dimensao);

        matriz[2][3] = 1;
        matriz[7][1] = 1;
        matriz[0][5] = 1;
        matriz[3][2] = 1;
        matriz[9][9] = 1;

        Matriz.exibirMatriz(matriz, dimensao, dimensao);

        // converter a matriz especial em lista de dados
        ArrayList<Dado> lista = new ArrayList<>();
        Matriz.converterMatrizEmLista(matriz, dimensao, dimensao, lista);
        Matriz.exibirLista(lista);
    }
}