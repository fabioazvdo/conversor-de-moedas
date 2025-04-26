
# Conversor de Moedas

Projeto desenvolvido no programa **ONE - Oracle Next Education**, realizado pela Alura em parceria com a Oracle. Este projeto foi criado durante a especialização em back-end e utiliza **Java 23**. O **Conversor de Moedas** é uma aplicação que permite conversões entre várias moedas globais, utilizando uma webAPI para obter taxas de conversão atualizadas.

## 🚀 Funcionalidades

- Conversão entre diversas moedas, incluindo:
  - BRL (Real Brasileiro)
  - ARS (Peso Argentino)
  - EUR (Euro)
  - USD (Dólar Americano)
- Obtenção de taxas de conversão em tempo real.
- Interface de linha de comando simples e fácil de usar.
- Histórico de conversões.
- Exportação do histórico das operações efetuadas.

## 🛠 Pré-requisitos

Para utilizar o **Conversor de Moedas**, é necessário realizar algumas configurações:

1. **API Key da webAPI**:
   - Insira sua **API Key** no arquivo `/src/Modelos/DadosConversor.java`.
   - A API Key pode ser obtida gratuitamente em: [ExchangeRate API](https://www.exchangerate-api.com/).

2. **Biblioteca Gson**:
   - Baixe e insira manualmente a biblioteca **Gson** no projeto.
   - A biblioteca pode ser encontrada em: [Gson no Maven Repository](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.10.1).

## 🗂 Estrutura do Projeto

A estrutura principal do projeto se encontra organizada da seguinte forma:

```
conversor-de-moedas/
├── .gitignore
├── .idea/                  # Configurações do IntelliJ IDEA
├── conversor-de-moedas.iml
├── src/                    # Código-fonte principal
│   ├── modelos/            # Modelos da aplicação
│   └── (outros pacotes e arquivos do projeto)
```

## 📦 Como Configurar e Executar o Projeto

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/fabioazvdo/conversor-de-moedas.git
   cd conversor-de-moedas
   ```

2. **Abra o projeto em seu IDE**:
   - Recomendamos o uso do **IntelliJ IDEA** para abrir e configurar o projeto.

3. **Configure o SDK**:
   - Certifique-se de que o **Java 23** está configurado como ambiente de desenvolvimento.

4. **Insira a API Key**:
   - Abra o arquivo `DadosConversor.java` em `/src/Modelos` e insira sua API Key.

5. **Adicione a biblioteca Gson**:
   - Baixe a biblioteca e adicione-a ao projeto como dependência.

6. **Execute o projeto**:
   - Localize a classe principal e execute a aplicação.

## 🌟 Contribuições

Contribuições são bem-vindas! Se você deseja contribuir:

- Faça um fork do projeto.
- Crie uma branch para suas alterações: `git checkout -b minha-branch`.
- Envie um pull request descrevendo as alterações realizadas.

## 📞 Contato

Criado por [Fabio Azevedo](https://github.com/fabioazvdo). Caso tenha dúvidas ou sugestões, não hesite em entrar em contato!
