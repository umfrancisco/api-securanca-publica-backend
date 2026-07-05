# API Segurança Pública

Uma API REST desenvolvida com Spring Boot que fornece acesso a estatísticas criminais oficiais do Estado de São Paulo. Este projeto expõe dados criminais consolidados de cidades do Estado de São Paulo através de uma API RESTful, permitindo consultas de ocorrências criminais e taxas de delitos por ano e localidade.

## Tecnologias

- Java 17
- Spring Boot 4
- Maven
- Spring Web MVC


## Endpoints da API

### Ocorrências Criminais

- **GET** `/api/crime/ocorrencia`
  - Retorna todas as ocorrências criminais registradas
  - Response: Lista de objetos `Crime`

- **GET** `/api/crime/ocorrencia/{cidade}`
  - Retorna ocorrências criminais de uma cidade específica
  - Path Parameters:
    - `cidade`: Nome da cidade (ex: "São Paulo", "Campinas")
  - Response: Lista de objetos `Crime` filtrados por cidade

## Dados Disponíveis

A API trabalha com dados de crimes como:
- **Homicídios**
- **Furtos**
- **Roubos**
- **Frv** (Furto e roubo de veículos)

Os dados incluem séries históricas por ano, cobrindo desde 2001 até 2025.

## Exemplos de uso

### Obter todas as ocorrências
curl http://localhost:8080/api/crime/ocorrencia

### Obter ocorrências de São Paulo
curl http://localhost:8080/api/crime/ocorrencia/sao_paulo

### Obter ocorrências de Campinas
curl http://localhost:8080/api/crime/ocorrencia/campinas
