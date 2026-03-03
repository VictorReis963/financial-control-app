# 💰 Financial Control App

---

# 🇧🇷 Versão em Português

## 📌 Descrição

Aplicação web para gerenciamento financeiro pessoal desenvolvida com Spring Boot, seguindo arquitetura em camadas (MVC).
Permite o cadastro e controle de receitas e despesas com persistência em banco de dados PostgreSQL e visualização gráfica por meio de dashboard interativo.

---

## 🏗️ Arquitetura

A aplicação está estruturada em camadas:

* **Controller** → Responsável pelas requisições HTTP
* **Service** → Regras de negócio
* **Repository** → Acesso a dados com Spring Data JPA
* **Model (Entity)** → Representação das tabelas no banco

Utiliza **JPA/Hibernate** para mapeamento objeto-relacional (ORM).

---

## 🚀 Tecnologias

### Backend

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* PostgreSQL

### Frontend

* HTML5
* TailwindCSS
* Chart.js

### Versionamento

* Git
* GitHub

---

## 📊 Funcionalidades

* Cadastro de receitas
* Cadastro de despesas
* Listagem de transações
* Exclusão de registros
* Cálculo automático de saldo
* Dashboard com gráfico dinâmico

---

## ⚙️ Como Executar

### 1️⃣ Clonar repositório

git clone https://github.com/VictorReis963/financial-control-app.git

### 2️⃣ Criar banco PostgreSQL

financial_db

### 3️⃣ Configurar application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/financial_db
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

### 4️⃣ Executar aplicação

Rodar a classe com @SpringBootApplication

Aplicação disponível em:
http://localhost:8080

---

## 🔎 Conceitos Aplicados

* Arquitetura MVC
* REST Controllers
* Injeção de Dependência
* ORM com JPA
* Persistência relacional
* Integração backend + frontend

---

# 🇺🇸 English Version

## 📌 Description

Web application for personal financial management developed with Spring Boot, following a layered MVC architecture.
It allows users to manage income and expenses with PostgreSQL persistence and interactive dashboard visualization.

---

## 🏗️ Architecture

The application is structured in layers:

* **Controller** → Handles HTTP requests
* **Service** → Business logic
* **Repository** → Data access layer using Spring Data JPA
* **Model (Entity)** → Database table representation

The project uses **JPA/Hibernate** for Object-Relational Mapping (ORM).

---

## 🚀 Technologies

### Backend

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* PostgreSQL

### Frontend

* HTML5
* TailwindCSS
* Chart.js

### Version Control

* Git
* GitHub

---

## 📊 Features

* Income registration
* Expense registration
* Transaction listing
* Record deletion
* Automatic balance calculation
* Dynamic financial dashboard

---

## ⚙️ How to Run

### 1️⃣ Clone the repository

git clone https://github.com/VictorReis963/financial-control-app.git

### 2️⃣ Create PostgreSQL database

financial_db

### 3️⃣ Configure application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/financial_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

### 4️⃣ Run the application

Execute the main class annotated with @SpringBootApplication

Application available at:
http://localhost:8080

---

## 🔎 Technical Concepts Applied

* MVC Architecture
* REST Controllers
* Dependency Injection
* ORM with JPA
* Relational Persistence
* Backend + Frontend Integration

---

## 👨‍💻 Author

Victor Reis
Computer Science Student
Backend and System Architecture Enthusiast

---

## 📄 License

Educational and portfolio demonstration purposes.
