import csv
from aluno import Aluno

class GestaoAcademica:
    """Gerencia a coleção de alunos e oferece operações sobre ela"""

    def __init__(self):
        self.alunos = []

    def carregar_de_csv(self, caminho_arquivo):
        """Lê o csv e instancia um objeto Aluno para cada linha.

        Args:
            caminho_arquivo (str): Caminho para o arquivo alunos.csv.
                Ex: "alunos.csv" ou "/home/user/projeto/alunos.csv"
        """
        with open(caminho_arquivo, mode="r", encoding="utf-8") as arquivo:
            leitor = csv.DictReader(arquivo)
            for linha in leitor:
                aluno = Aluno(
                    nome=linha["Nome"],
                    curso=linha["Curso"],
                    sexo=linha["Sexo"],
                    ano_ingresso=linha["AnoIngresso"],
                )
                self.alunos.append(aluno)

    def ordenar_por_nome(self):
        """Retorna uma nova lista ordenada por nome (ordem alfabética)."""
        return sorted(self.alunos, key=lambda a: a.nome)

    def ordenar_por_ano(self):
        """Retorna a lista de alunos ordenada por ano de ingresso.

        Returns:
            list[Aluno]: Nova lista ordenada do ano mais antigo ao mais recente.
        """
        return sorted(self.alunos, key=lambda a: a.ano_ingresso)

    def buscar_por_nome(self, nome_procurado):
        """Busca um aluno pelo nome exato na lista.

        Args:
            nome_procurado (str): Nome completo e exato do aluno.
                A busca é case-sensitive: "ana silva" é diferente de "Ana Silva".

        Returns:
            Aluno: O objeto Aluno encontrado, ou None se não existir.
        """
        for aluno in self.alunos:
            if aluno.nome == nome_procurado:
                return aluno
        return None

    def contar_por_ano(self):
        """Retorna um dicionário {ano: quantidade_de_alunos}."""
        contagem = {}
        for aluno in self.alunos:
            ano = aluno.ano_ingresso
            if ano in contagem:
                contagem[ano] += 1
            else:
                contagem[ano] = 1
        return contagem