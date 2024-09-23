# API REST com Spring Boot e Spring Security usando JWT(Auth0)

Este é um projeto de API REST que simula o funcionamento de uma clínica médica, com operações CRUD para gerenciar médicos e pacientes. O sistema inclui classes que representam esses usuários, e ambos possuem login e funcionalidades específicas de acordo com seus perfis. Foi desenvolvido em Java, utilizando Spring Boot e Spring Security, com autenticação e autorização stateless por meio de JWT.

## Table of Contents

- [Funcionalidades](#Funcionalidades)
- [Requisitos](#Requisitos)
- [Execução](#Execução)
- [API Endpoints](#API-Endpoints)
- [Banco de dados](#Banco-de-dados)

# Funcionalidades
- Implementação de autenticação / Autorização com Spring Security (JWT)
- Operações CRUD como cadastrar novo medico ou paciente, atualizar dados dentre outros.

# Requisitos
- Java 17 +
- Maven
- MySQL (configurável no arquivo `application.properties`)
- Ferramenta de preferência para testar endpoints.

# Execução
1. Faça o clone o repositório:

    ```
    git clone https://github.com/monteirobiel/med.voll-API.git
    ```

2. Navegue até o diretório do projeto:

    ```
    cd med.voll-AP
    ```

3. Execute o aplicativo usando Maven:

    ```
    mvn spring-boot:run
    ```

4. API podera ser acessada em `http://localhost:8080`.

# API Endpoints
## Login

- **POST** `/login`
    - Corpo da requisição para operação:
      ```json
      {
        "username": "cpf do paciente ou crm do medico",
        "password": "senha"
      }
      ```
    - Retorna um token JWT válido para autenticações futuras.

## Acesso restrito para Médicos

- **GET** `/doctors`
    - Retorna informações específicas para usuários do tipo **Médico**.
- **POST** `/doctors`
    - Registra as informações do tipo **Médico**.
- **PUT** `/doctors`
    - Corpo da requisição para operação:
```json
      {
        "id": "id do medico",
        "phone": "telefone do medico"
      }
```
Atualiza informações do tipo **Médico**.

- **DELETE** `/patients`
    - Desativa o cadastro do tipo **Médico**.

## Acesso restrito para Pacientes


- **GET** `/patients`
    - Retorna informações específicas para usuários do tipo **Paciente**.
- **POST** `/patients`
    - Registra as informações do tipo **Paciente**.
- **PUT** `/patients`
    - Corpo da requisição para operação:
```json
      {
        "id": "id do paciente",
        "phone": "telefone do paciente"
      }
```
Atualiza informações do tipo **Paciente**.


- **DELETE** `/patients`
    - Desativa o cadastro do tipo **Paciente**.
  

## Banco de dados

A estrutura do banco de dados será criada automaticamente pelo Flyway, de acordo com as migrations localizadas em `src/main/resources/db/migration`.

Para fins de testes, acessa o banco de dados e execute os seguintes comandos SQL:

```
insert into users(id, username, password) values(1, '00011122233', '$2a$10$1g.8vUZgxS10V0FcORrGyOUTFroyioIPHyGSZWSQSNfe.DNQdU19C');
insert into patients(id, name, email, cpf) values(1, 'Paciente beltrana', 'paciente@email.com.br', '00011122233');

insert into users(id, username, password) values(2, '112233', '$2a$10$1g.8vUZgxS10V0FcORrGyOUTFroyioIPHyGSZWSQSNfe.DNQdU19C');
insert into doctors(id, name, email, crm) values(2, 'Medico fulano', 'medico@email.com.br', '112233');
```

Será inserido um médico com CRM (username): **112233** e senha **123456**. Também será inserido um paciente com CPF (username): **00011122233** e senha **123456**
