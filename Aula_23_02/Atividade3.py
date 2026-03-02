from util import ler_arquivo_lista
lista = []

ler_arquivo_lista('numeros.txt', lista)

print('Tamanho da lista: ', len(lista))
print(lista)