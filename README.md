# Payment API

API REST para processamento de pagamentos desenvolvida com Spring Boot.

## Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Lombok

## Padrões de Projeto Aplicados

### Repository

Responsável pela comunicação com o banco de dados através do Spring Data JPA.

### Strategy

Permite diferentes formas de processamento de pagamento:

* PIX
* Cartão de Crédito
* Boleto

Cada método possui sua própria estratégia de processamento.

### Facade

Centraliza a lógica de pagamento através da classe `PaymentFacade`, simplificando o acesso às estratégias e ao repositório.

## Estrutura do Projeto

```text
src/main/java
├── controller
├── entity
├── repository
├── service
├── strategy
└── facade
```

## Configuração do Banco

Criar um banco MySQL chamado:

```sql
CREATE DATABASE payment_db;
```

Configuração utilizada:

```properties
spring.datasource.url=jdbc:mysql://localhost:3307/payment_db
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Endpoints

### Criar pagamento

POST `/payments`

Exemplo:

```json
{
  "amount": 150.0,
  "paymentMethod": "PIX"
}
```

### Listar pagamentos

GET `/payments`

### Buscar pagamento por ID

GET `/payments/{id}`

### Remover pagamento

DELETE `/payments/{id}`

## Métodos de pagamento suportados

* PIX
* CREDIT_CARD
* BOLETO

## Objetivo

Projeto desenvolvido para prática dos padrões de projeto no ecossistema Spring, utilizando os conceitos de:

* Singleton (Beans gerenciados pelo Spring)
* Strategy
* Repository
* Facade
* Injeção de Dependência
* API REST
