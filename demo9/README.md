# Note API

### Простой REST API для управления заметками, написанный на Java с использованием Spring Boot и PostgreSQL

---
- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL (Docker)
- Docker Compose
---
## Описание API
POST /note - создать заметку

GET /note/{id} - получить заметку по id

GET /notes - получить все заметки

Реализована обратотка ошибок

---
## Запуск проекта

docker-compose up --build

