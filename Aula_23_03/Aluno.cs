public class Aluno {
    public string Nome { get; private set; }
    public string Email { get; private set; }

    public Aluno(string nome) {
        Nome = nome;
        Email = GerarEmail(nome);
    }

    private string GerarEmail(string nome) {
        string[] dadosNome = nome.Split(' ');
        return dadosNome[0].ToLower() + "." + dadosNome[dadosNome.Length - 1].ToLower() + "@email.com";
    }
}