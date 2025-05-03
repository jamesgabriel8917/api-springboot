# API Spring Boot

Este projeto é uma API RESTful desenvolvida com Spring Boot, utilizando o Gradle como ferramenta de build.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Gradle
- Heroku (para deploy)

## Estrutura do Projeto

O projeto segue a estrutura padrão de aplicações Spring Boot:
```
api-springboot/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── example/
│ │ │ └── apispringboot/
│ │ │ ├── controllers/
│ │ │ ├── models/
│ │ │ ├── repositories/
│ │ │ └── services/
│ └── resources/
│ └── application.properties
├── build.gradle
├── settings.gradle
└── Procfile
```

## Como Executar o Projeto

### Pré-requisitos

- Java 17 instalado
- Gradle instalado

### Passos para execução

1. Clone o repositório:

```bash
git clone https://github.com/jamesgabriel8917/api-springboot.git
cd api-springboot

./gradlew bootRun
```

## Deploy no Heroku
- Este projeto está configurado para deploy no Heroku. O arquivo Procfile está presente na raiz do projeto para facilitar o processo de deploy.

