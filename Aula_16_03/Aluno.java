public class Aluno {
    public String nome;
    public String email;

    public Aluno(String nome) {
        this.nome = nome;
        this.email = gerarEmail(nome);
    }

    private String gerarEmail(String nome) {
        String nomes[] = nome.split(" ");
        return nomes[0].toLowerCase() + "." + nomes[nomes.length - 1].toLowerCase() + "@ufn.edu.br";
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome='" + this.nome + '\'' + ", email='" + this.email + '\'' +  '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aluno aluno = (Aluno) obj;
        return email.equals(aluno.email);
    }

}