from Clima import Clima
import csv

class Principal:
    """Classe principal para análise de dados climáticos.
    
    Esta classe contém métodos para ler os dados climáticos de um arquivo CSV,
    identificar a estação do ano com base no mês e analisar os dados para determinar
    as estações que menos chove, mais chove, mais quente e mais amena.
    """

    def __init__(self):
        """Inicializa a classe Principal.
        
        Este método é chamado quando uma instância da classe Principal é criada.
        Ele pode ser usado para inicializar atributos ou realizar configurações iniciais, se necessário.
        """

        self.lista_climas = []
        self.nome_arquivo = "dadosClimaticos.csv"

    def ler_arquivo(self):
        """Lê os dados climáticos de um arquivo CSV e armazena-os em uma lista de objetos Clima.
        """

        with open(self.nome_arquivo, mode='r', encoding='utf-8') as arquivo_csv:
            leitor_csv = csv.reader(arquivo_csv)
            next(leitor_csv)  # Pula o cabeçalho
            for linha in leitor_csv:
                if linha[0] != "":  # Verifica se a linha não está vazia
                    clima = Clima(ano=linha[0], mes=linha[1], temperatura=linha[2], precipitacao=linha[3])
                    self.lista_climas.append(clima)

    def identificar_estacao(self, mes):
        """Identifica a estação do ano com base no mês fornecido.

        Args:
            mes (str): O mês para o qual a estação deve ser identificada.

        Returns:
            str: A estação do ano correspondente ao mês fornecido.
        """

        estacao = ""
        if mes in ["Dezembro", "Janeiro", "Fevereiro"]:
            estacao = "Verão"
        elif mes in ["Março", "Abril", "Maio"]:
            estacao = "Outono"
        elif mes in ["Junho", "Julho", "Agosto"]:
            estacao = "Inverno"
        elif mes in ["Setembro", "Outubro", "Novembro"]:
            estacao = "Primavera"
        return estacao

    def exibir_dados_clima(self):
        """Exibe os dados climáticos armazenados na lista_climas.

        Este método percorre a lista de objetos Clima e imprime cada um deles usando o método __str__.
        """

        for clima in self.lista_climas:
            print(clima)

    def analisar(self):
        """Imprime no terminal a estação que menos chove, mais chove,
        mais quente e mais amena com base nos dados do CSV.
        """

        self.ler_arquivo()
        lista_estacao_chove_menos = []
        lista_estacao_chove_muito = []
        lista_estacao_quente = []
        lista_estacao_amena = []
    
        for clima in self.lista_climas:
            estacao = self.identificar_estacao(clima.mes)
            if clima.precipitacao == "nada" or clima.precipitacao == "pouca":
                lista_estacao_chove_menos.append(estacao)
            elif clima.precipitacao == "muita":
                lista_estacao_chove_muito.append(estacao)
        
            if clima.temperatura == "Quente":
                lista_estacao_quente.append(estacao)
            elif clima.temperatura == "Ameno":
                lista_estacao_amena.append(estacao)
    
        print("Estação que menos chove:", max(set(lista_estacao_chove_menos), key=lista_estacao_chove_menos.count))
        print("Estação que mais chove:", max(set(lista_estacao_chove_muito), key=lista_estacao_chove_muito.count))
        print("Estação mais quente:", max(set(lista_estacao_quente), key=lista_estacao_quente.count))
        print("Estação mais amena:", max(set(lista_estacao_amena), key=lista_estacao_amena.count))

if __name__ == "__main__":
    p = Principal()
    p.analisar()