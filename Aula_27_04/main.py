from gestao_academica import GestaoAcademica

def exibir_menu():
    print("\n=== Sistema de Gestão Acadêmica ===")
    print("1 - Listar alunos ordenados por NOME")
    print("2 - Listar alunos ordenados por ANO de ingresso")
    print("3 - Buscar aluno por nome exato")
    print("4 - Mostrar quantidade de ingressantes por ano")
    print("0 - Sair")

def main():
    gestao = GestaoAcademica()
    gestao.carregar_de_csv("alunos.csv")
    print(f"{len(gestao.alunos)} alunos carregados com sucesso.")

    while True:
        exibir_menu()
        opcao = input("Escolha uma opção: ").strip()

        if opcao == "1":
            for aluno in gestao.ordenar_por_nome():
                print(aluno)

        elif opcao == "2":
            for aluno in gestao.ordenar_por_ano():
                print(aluno)

        elif opcao == "3":
            nome = input("Digite o nome exato: ").strip()
            resultado = gestao.buscar_por_nome(nome)
            if resultado:
                print("Aluno encontrado:")
                print(resultado)
            else:
                print("Aluno não encontrado.")

        elif opcao == "4":
            contagem = gestao.contar_por_ano()
            for ano in sorted(contagem.keys()):
                print(f"{ano}: {contagem[ano]} alunos")

        elif opcao == "0":
            print("Encerrando o programa. Até mais!")
            break

        else:
            print("Opção inválida, tente novamente.")

if __name__ == "__main__":
    main()