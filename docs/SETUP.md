# Passbook Vault Setup Guide

## Prerequisites

* Java 21
* Maven 3.9+
* PostgreSQL 16+

---

## Clone Repository

```bash
git clone https://github.com/ajinkyaedu6643/passbook-vault.git
cd passbook-vault
```

---

## Create Database

```sql
CREATE DATABASE passbook_vault;
```

---

## Configure Application

Update application.properties:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/passbook_vault
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update

file.upload-dir=D:/PassbookVaultUploads
```

---

## Build Project

```bash
mvn clean install
```

---

## Run Application

```bash
mvn spring-boot:run
```

Application will start on:

```text
http://localhost:8080
```

---

## Verify Setup

1. Create a bank account.
2. Upload a document.
3. Download the document.
4. Test search APIs.

If all operations succeed, the application is configured correctly.
