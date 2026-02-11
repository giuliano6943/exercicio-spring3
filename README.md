# 🚀 Exercício Spring Boot 3 – API REST

Este repositório contém um exercício de **Spring Boot 3** desenvolvido como parte do módulo de **API REST, camadas, CRUD, tratamento de exceções e validações** do curso **Java Spring Professional**.

---

## 🧠 Sobre o Projeto

Este projeto demonstra a criação de uma **API REST em Java** utilizando o framework **Spring Boot 3**, com foco em:

- ✅ Arquitetura em camadas (Controller → Service → Repository)
- ✅ Operações CRUD (Create, Read, Update, Delete)
- ✅ Validações de entrada de dados
- ✅ Tratamento de erros e exceções
- ✅ Persistência com JPA/Hibernate

O objetivo é construir uma API robusta, organizada e seguindo boas práticas de desenvolvimento.

---

## 🚀 Tecnologias Utilizadas

| Tecnologia        | Versão / Descrição |
|------------------|--------------------|
| Java             | 17 ou superior |
| Spring Boot      | 3.x |
| Spring Web       | Desenvolvimento de API REST |
| Spring Data JPA  | Persistência com banco de dados |
| JPA / Hibernate  | Mapeamento objeto-relacional (ORM) |
| Maven            | Gerenciamento de dependências |

---

## 📁 Estrutura do Projeto

Estrutura típica de um projeto Spring Boot organizado em camadas:

src/
├── main/
│   ├── java/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── model/
│   │   └── exception/
│   └── resources/
│       └── application.properties
└── test/

Código

---

## 🔧 Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- ☕ Java 17 ou superior
- 📦 Maven
- 🗄️ Banco de dados configurado (H2, PostgreSQL, MySQL, etc.)

---

## 🏃 Como Executar o Projeto

### 1️⃣ Clone o repositório
```bash
git clone https://github.com/giuliano6943/exercicio-spring3.git
```
2️⃣ Acesse o diretório
```bash
cd exercicio-spring3
```
3️⃣ Execute a aplicação
```bash
mvn spring-boot:run
```
A aplicação iniciará no endereço padrão:
```bash
http://localhost:8080
```

📌 Endpoints da API
A API disponibiliza os seguintes endpoints para gerenciamento de clientes:

Método	Endpoint	Descrição
GET	/clients	Listar todos os clientes
GET	/clients/{id}	Buscar cliente por ID
POST	/clients	Inserir novo cliente
PUT	/clients/{id}	Atualizar cliente existente
DELETE	/clients/{id}	Deletar cliente
📦 Executando Testes
Caso existam testes implementados, você pode executá-los com:

```bash
mvn test
```

📝 Observações
Este exercício foi desenvolvido com foco em:

Estruturação correta de camadas

Boas práticas em APIs REST

Tratamento centralizado de exceções

Validações com Bean Validation

Organização de código para projetos reais

👨‍💻 Autor
Giuliano D'Agosto Neto  
📌 Foco atual: Desenvolvimento Backend com Java & Spring Boot
