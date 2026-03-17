class Clima: #ano, mês, temperatura, precipitação
    """Representa um registro climático mensal.
    
    Atributos:
        ano (str): Ano do registro, ex: "2024, 2023, etc."
        mes (str): Mês do registro, ex: "Janeiro, Fevereiro, Março, etc."
        temperatura (str): Temperatura média do mês, ex: "Ameno, Quente, Frio"
        precipitacao (str): Precipitação total do mês, ex: "Nada, Pouca, Média, Muita"
    """

    def __init__(self, ano, mes, temperatura, precipitacao):
        """Representa um registro climático mensal.

        Args:
            ano (str): Ano do registro climático, ex: "2024, 2023, etc."
            mes (str): Mês do registro climático, ex: "Janeiro, Fevereiro, Março, etc."
            temperatura (str): Temperatura média do mês, ex: "Ameno, Quente, Frio"
            precipitacao (str): Precipitação total do mês, ex: "Nada, Pouca, Média, Muita"
        """

        self.ano = ano
        self.mes = mes
        self.temperatura = temperatura
        self.precipitacao = precipitacao
    def __str__(self):
        """Retorna uma representação em string do registro climático.

        Returns:
            str: Uma string formatada contendo o ano, mês, temperatura e precipitação do registro climático.
        """

        return f"Ano: {self.ano}, Mês: {self.mes}, Temperatura: {self.temperatura}, Precipitação: {self.precipitacao}"
    def __eq__(self, other):
        """Compara dois objetos Clima para verificar se são iguais com base no ano e mês.

        Args:
            other (Clima): Outro objeto Clima a ser comparado.

        Returns:
            bool: True se os objetos forem iguais, False caso contrário.
        """
        
        if isinstance(other, Clima):
            return self.ano == other.ano and self.mes == other.mes
        return False
    