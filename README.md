# 📚 Sistema de Gerenciamento de Biblioteca

Sistema de gerenciamento de biblioteca desenvolvido em Java com integração ao banco de dados MySQL. O projeto permite cadastrar livros, gerenciar empréstimos e devoluções.

## 🚀 Tecnologias Utilizadas

- **Java 22**
- **Maven** - Gerenciamento de dependências
- **MySQL** - Banco de dados
- **JUnit 5** - Testes unitários
- **JDBC** - Conexão com banco de dados

## 📋 Pré-requisitos

- Java JDK 22 ou superior
- MySQL 8.0 ou superior
- Maven 3.x

## 🔧 Configuração do Banco de Dados

1. Crie um banco de dados MySQL chamado `biblioteca`:

```sql
CREATE DATABASE biblioteca;
```

2. O sistema espera as seguintes credenciais (configuráveis em `Conexao.java`):
   - **Host:** localhost:3306
   - **Usuário:** root
   - **Senha:** kauafelix123@

## 📦 Instalação

1. Clone o repositório:
```bash
git clone https://github.com/kauaafeelix/treino-prova.git
cd treino-prova
```

2. Compile o projeto com Maven:
```bash
mvn clean install
```

3. Execute o teste de conexão:
```bash
mvn exec:java -Dexec.mainClass="KauaFelix.infrastructure.database.ConexaoTeste"
```

## 🏗️ Estrutura do Projeto

```
src/
├── main/
│   └── java/
│       └── KauaFelix/
│           ├── model/
│           │   ├── Livro.java           # Modelo de dados do livro
│           │   └── Emprestimo.java      # Modelo de dados do empréstimo
│           ├── service/
│           │   └── BibliotecaService.java  # Lógica de negócio
│           ├── infrastructure/
│           │   ├── database/
│           │   │   ├── Conexao.java        # Configuração de conexão
│           │   │   └── ConexaoTeste.java   # Teste de conexão
│           │   └── persistence/
│           │       ├── LivroRepository.java      # Operações de banco (Livros)
│           │       └── EmprestimoRepository.java # Operações de banco (Empréstimos)
│           └── Main.java
└── test/
    └── java/
        └── BibliotecaServiceTest.java  # Testes unitários
```

## 🎯 Funcionalidades

### Gerenciamento de Livros
- ✅ Cadastrar novos livros
- ✅ Buscar livro por ID
- ✅ Listar todos os livros
- ✅ Listar livros disponíveis
- ✅ Atualizar informações do livro
- ✅ Deletar livros

### Gerenciamento de Empréstimos
- ✅ Realizar empréstimo de livro
- ✅ Registrar devolução de livro
- ✅ Controle de disponibilidade automático

## 📖 Modelo de Dados

### Livro
```java
- id: int
- titulo: String
- autor: String
- anoPublicacao: int
- disponivel: boolean
```

### Empréstimo
```java
- id: int
- idLivro: int
- nomePessoa: String
- dataEmprestimo: LocalDate
- dataDevolucao: LocalDate
```

## 🧪 Executando os Testes

Execute os testes unitários com:

```bash
mvn test
```

Os testes cobrem:
- Cadastro de livros
- Busca por ID
- Listagem de livros
- Atualização de informações
- Sistema de empréstimo/devolução
- Exclusão de livros

## 📝 Exemplo de Uso

```java
BibliotecaService service = new BibliotecaService();

// Cadastrar um livro
int idLivro = service.cadastrarLivro("Clean Code", "Robert Martin", 2008);

// Buscar livro por ID
Livro livro = service.buscarLivroPorId(idLivro);

// Emprestar livro
boolean emprestado = service.emprestarLivro(idLivro, "João Silva");

// Devolver livro
boolean devolvido = service.devolverLivro(idLivro);
```

## ⚠️ Observações

- As credenciais do banco de dados estão hardcoded no arquivo `Conexao.java`. Para produção, considere usar variáveis de ambiente.
- Algumas funcionalidades em `BibliotecaService.java` ainda precisam ser implementadas (marcadas com `// implementar`).

## 👤 Autor

**Kauã Felix**

- GitHub: [@kauaafeelix](https://github.com/kauaafeelix)

## 📄 Licença

Este projeto foi desenvolvido para fins de estudo e treino.
