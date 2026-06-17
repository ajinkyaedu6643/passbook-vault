# 🏦 Passbook Vault

> A secure bank account and document management system built with Java 21 & Spring Boot 3.

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=flat-square&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-blue?style=flat-square&logo=postgresql)
![Status](https://img.shields.io/badge/Status-Pre--release%20v0.2.0-yellow?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-lightgrey?style=flat-square)

---

## 📌 About

**Passbook Vault** is a personal learning project — a Spring Boot REST API application for securely managing bank account information and associated documents such as passbook scans, cheque images, account records, and supporting files.

---

## ✨ Features

### 🏛️ Account Management
- Bank Account CRUD Operations
- Account Search & Filters
- Universal Keyword Search

### 📄 Document Management
- Document Upload & Download API
- Document Metadata Management
- Local File Storage

### 📊 Dashboard
- Dashboard Summary API

### ⚙️ Other
- Global Exception Handling
- PostgreSQL Integration
- Docker Support (v0.3.0)

---

## 🛠️ Technology Stack

| Technology | Version |
|---|---|
| Java | 21 |
| Spring Boot | 3.x |
| Spring Data JPA | Latest |
| PostgreSQL | Latest |
| Maven | Latest |
| Docker | (planned v0.3.0) |

---

## 🚀 Getting Started

### Prerequisites
- Java 21+
- PostgreSQL
- Maven

### Run Locally

```bash
# Clone the repository
git clone https://github.com/ajinkyaedu6643/passbook-vault.git

# Navigate to project
cd passbook-vault

# Configure database in application.properties
# spring.datasource.url=jdbc:postgresql://localhost:5432/passbook_vault

# Run the application
./mvnw spring-boot:run
```

---

## 🗺️ Roadmap

| Version | Feature | Status |
|---|---|---|
| v0.2.0 | Account Management, Document APIs, Search | ✅ Done |
| v0.3.0 | Docker Support, Swagger/OpenAPI Docs | 🔄 Planned |
| v0.4.0 | JWT Authentication & Authorization | 🔄 Planned |
| v0.5.0 | Frontend Application | 🔄 Planned |
| v1.0.0 | Production Ready Release | 🔄 Planned |

### Future Enhancements
- User Management
- Google Drive Backup
- Role-Based Access Control (RBAC)
- Audit Logging
- Cloud Deployment

---

## 📁 Project Structure

```
passbook-vault/
├── src/
│   └── main/
│       ├── java/         # Spring Boot application code
│       └── resources/    # Configuration files
├── docs/                 # Documentation
├── uploads/              # Local file storage
├── Dockerfile
├── docker-compose.yml
└── pom.xml
```

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

---

> 💡 *This is a personal portfolio project built for learning Spring Boot, REST APIs, and document management concepts.*
