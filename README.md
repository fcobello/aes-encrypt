![maven](https://github.com/fcobello/aes-encrypt/workflows/maven/badge.svg)
![license](https://img.shields.io/github/license/fcobello/aes-encrypt)

# aes-encrypt

Aplicação construida para exemplo de uso de criptografia AES

## Pré requisitos
Java 14 (https://openjdk.java.net/projects/jdk/14/)

Maven (https://maven.apache.org/download.cgi)

Executar os comandos na raiz do projeto

## Como Compilar

`mvn clean install`

## Como executar (Maven)

`mvn spring-boot:run`


## Como testar 
### Encriptar um dado

`curl -X GET 'http://localhost:8080/v1/encrypt/dado'`

### Decriptar um dado

`curl -X GET 'http://localhost:8080/v1/decrypt/dado'`