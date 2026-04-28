class Aluno:
    """Representa um aluno"""

    def __init__(self, nome, curso, sexo, ano_ingresso):
        self.nome = nome
        self.curso = curso
        self.sexo = sexo
        self.ano_ingresso = int(ano_ingresso)

    def __str__(self):
        return (
            f"O(a) aluno(a) {self.nome} "
            f"estuda no curso de {self.curso}, "
            f"é do sexo {self.sexo} "
            f"e ingressou em {self.ano_ingresso}"
        )