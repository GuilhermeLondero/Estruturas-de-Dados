class Aluno:
    def __init__(self, nome):
        self.nome = nome
        self.email = self.gerar_email(self.nome)
    
    def gerar_email(self, nome):
        dados_nome = nome.split()
        email = dados_nome[0].lower() + "." + dados_nome[-1].lower() + "@email.com"
        return email
    