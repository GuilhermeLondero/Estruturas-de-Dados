class Glicemia:
    def __init__(self, valor, data, hora):
        """construtor básico com os 3 atributos de classe

        Args:
            valor (int): de glicemia de sangue
            data (string): data da medição
            hora (string): hora da medição
        """
        self.valor = valor
        self.data = data
        self.hora = hora

    def __eq__(self, outro):
        if not isinstance(outro, Glicemia):
            return False
        return self.data == outro.data and self.hora == outro.hora
    
    def __str__(self):
        return f'Valor glicemia: {self.valor}. Data: {self.data}. Hora: {self.hora}'
    
    @staticmethod
    def calcular_media(lista):
        soma = 0
        for item in lista:
            soma += int(item.valor)
        return int(soma/len(lista))

    @staticmethod
    def calcular_mediana(lista):
        tamanho = len(lista)
        if tamanho % 2 != 0: #tamanho impar
            posicao_meio = int(tamanho / 2)
            return lista[posicao_meio]
        else: #tamanho da lista eh par
            posicao_meio = tamanho/2
            valor1 = lista[posicao_meio]
            valor2 = lista[posicao_meio-1]
            media = int((valor1 + valor2)/2)
            return media