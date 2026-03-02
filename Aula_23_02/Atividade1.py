import random
from util import popular_lista_arquivo

lista = []

n = int(input('Quantos numeros inteiros quer gerar? '))

i = 0

while (i < n):
    numero_sorteado = random.randint(0, 100000)
    if (numero_sorteado not in lista):
        lista.append(numero_sorteado)
        i+=1

lista.sort()
print('Total de elementos: ', len(lista))
popular_lista_arquivo(lista,"numeros.txt")