# Gerenciador de Estoque - API

API desenvolvida em Java para gerenciamento de estoque, com sistema de autenticação baseado em tokens JWT (JSON Web Token).

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Security
- JWT (Autenticação)
- JPA/Hibernate
- Banco de dados relacional (MySQL, PostgreSQL, etc.)
- Maven

## 📌 Funcionalidades

- Cadastro, edição, listagem e remoção de produtos no estoque
- Controle de quantidade e status dos itens
- Autenticação segura com JWT
- Controle de acesso a endpoints com base no token
- Integração com banco de dados via JPA

## 🔐 Autenticação

A autenticação é feita via JWT:
- O usuário realiza login com suas credenciais
- Recebe um token JWT válido
- Esse token deve ser enviado no header `Authorization` nas requisições protegidas:  
  ```
  Authorization: Bearer <seu_token>
  ```

## 📦 Como rodar o projeto localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/Berla1/gerenciador-estoque-api.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd gerenciador-estoque-api
   ```

3. Configure o arquivo `application.properties` ou `application.yml` com os dados do seu banco de dados e segredo do JWT.

4. Execute o projeto:
   - Via terminal:
     ```bash
     ./mvnw spring-boot:run
     ```
   - Ou importe no IntelliJ/Eclipse como projeto Maven e execute a classe principal.

## 📬 Endpoints principais

| Método | Endpoint               | Descrição                    |
|--------|------------------------|------------------------------|
| POST   | `/auth/register`       | Registra o usuário 
| POST   | `/auth/login`          | Autentica o usuário e gera o token para outras requisições |
| GET    | `/produtos`            | Lista os produtos            |
| POST   | `/produtos`            | Cadastra um novo produto     |
| PUT    | `/produtos/{id}`       | Atualiza um produto          |
| DELETE | `/produtos/{id}`       | Remove um produto            |

> ⚠️ Endpoints protegidos requerem o token JWT no cabeçalho da requisição.

