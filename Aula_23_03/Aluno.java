public class Aluno {
    private String nome;
    private String email;

    public Aluno(String nome) {
        this.nome = nome;
        this.email = gerarEmail(nome);
    }

    private String gerarEmail(String nome) {
        String[] dadosNome = nome.split(" ");
        return dadosNome[0].toLowerCase() + "." + dadosNome[dadosNome.length - 1].toLowerCase() + "@email.com";
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
}