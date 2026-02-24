import random
from util import popular_lista_arquivo

letras = 'abcdefghijklmnopqrstuvwxyz'
lista = []
n = int(input('Quantos nomes quer gerar? '))
tamanho_palavra = 5 #int(input('Qual o tamanho da palavra que quer gerar? '))

i = 0
while (i < n):
    palavra = ''
    for j in range(tamanho_palavra):
        posicao_letras = random.randint(0, len(letras)-1)
        palavra += letras[posicao_letras]
        
    if (palavra not in lista):
        lista.append(palavra)
        i+=1

lista.sort()
popular_lista_arquivo(lista,"nomes.txt")
# print (lista) #trocar por código que armazene a lista em arquivo nomes.txt