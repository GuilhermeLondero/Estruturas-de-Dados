#include <string>
#include <sstream>
#include <vector>
#include <algorithm>

using namespace std;

class Aluno {
private:
    string nome;
    string email;

    string gerarEmail(const string& nome) {
        vector<string> dadosNome;
        stringstream ss(nome);
        string token;
        while (ss >> token) dadosNome.push_back(token);

        string primeiro = dadosNome.front();
        string ultimo = dadosNome.back();
        transform(primeiro.begin(), primeiro.end(), primeiro.begin(), ::tolower);
        transform(ultimo.begin(), ultimo.end(), ultimo.begin(), ::tolower);

        return primeiro + "." + ultimo + "@email.com";
    }

public:
    Aluno(const string& nome) : nome(nome), email(gerarEmail(nome)) {}

    string getNome() const { return nome; }
    string getEmail() const { return email; }
};