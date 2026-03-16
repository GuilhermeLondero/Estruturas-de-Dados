import java.util.ArrayList;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
        ArrayList<Aluno> alunos = new ArrayList<>();
        
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("Digite o nome do aluno: ");
            String nome = teclado.nextLine().toUpperCase();
            Aluno aluno = new Aluno(nome);
            if (!alunos.contains(aluno)) {
                alunos.add(aluno);
            }
        }

        alunos.sort((a1,a2) -> a1.nome.compareTo(a2.nome));
        
        
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }