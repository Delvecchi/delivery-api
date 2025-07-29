# Delivery Tech API

Sistema de delivery desenvolvido com Spring Boot 3.5.3 e Java 21, utilizando as mais recentes funcionalidaes da linguagem.

## 📋 Sobre o Projeto

Este projeto foi desenvolvido como parte da disciplina **Arquitetura de Sistemas** e representa a base de um sistema de delivery completo. A aplicação demonstra o uso de tecnologias modernas e boas práticas.

## 🚀 Tecnologias

- **Java 21 LTS** (versão mais recente)
- Spring Boot 3.5.3
- Spring Web - APIs REST
- Spring Data JPA - Persistência de dados
- H2 Database - Banco em memória para desenvolvimento
- Maven - Gerenciador de dependências

## ⚡ Recursos Modernos Utilizados

- Records (Java 14+)
- Text Blocks (Java 15+)
- Pattern Matching (Java 17+)
- Virtual Threads (Java 21)

## 🏃‍♂️ Como executar

1. **Pré-requisitos:** JDK 21 instalado
2. Clone o repositório
3. Execute: `./mvnw spring-boot:run`
4. Acesse: http://localhost:8080/health

## 📋 Endpoints

- GET /health - Status da aplicação (inclui versão Java)
- GET /info - Informações da aplicação
- GET /h2-console - Console do banco H2

## 🔧 Configuração

- Porta: 8080
- Banco: H2 em memória
- Profile: development

## 👨‍💻 Desenvolvedor

Heitor Delvecchi - Arquitetura de Sistemas Turma 1  
Desenvolvido com JDK 21 e Spring Boot 3.5.3
