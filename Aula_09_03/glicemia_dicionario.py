lista_glicemica = []
nome_arquivo = './glicemia.txt'

lista_dicionarios_glicemica = []

def calcular_media(lista):
    soma = 0
    for item in lista:
        soma += int(item["valor"])
    
    return int(soma/len(lista))

def calcular_mediana(lista):
    ordenada = sorted(lista, key=lambda g: int(g.valor))
    tamanho = len(ordenada)
    meio = tamanho // 2

    if tamanho % 2 != 0:   # ímpar → elemento do meio
        return int(ordenada[meio].valor)
    else:                   # par → média dos dois do meio
        return int((int(ordenada[meio - 1].valor) + int(ordenada[meio].valor)) / 2)

def esta_contido(dicionario, lista_dicionarios):
    for item in lista_dicionarios:
        if item["data"] == dicionario["data"] and item["hora"] == dicionario["hora"]:
            return True
        
    return False

with open(nome_arquivo, 'r', encoding='utf8') as leitor:
    for linha in leitor:
        valor, data, hora = linha.split(',')
        dados = {
            "valor": valor,
            "data": data,
            "hora": hora
        }
        if not esta_contido(dados, lista_dicionarios_glicemica):
            lista_dicionarios_glicemica.append(dados)
    

print('Quantidade de dados lidos: ', len(lista_dicionarios_glicemica))
print('Media glicemica', calcular_media(lista_dicionarios_glicemica))