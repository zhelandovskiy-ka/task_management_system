
# Task Management System

## Описание

Task Management System - это простое приложение для управления задачами, разработанное с использованием Java, Spring Boot и PostgreSQL. Приложение поддерживает функции создания, редактирования, удаления и просмотра задач. Также реализована система аутентификации и авторизации с использованием JWT.

## Технологии

- Java 17+
- Spring Boot
- Spring Security
- PostgreSQL
- Docker & Docker Compose
- Swagger OpenAPI

## Запуск проекта

### Шаг 1: Склонируйте репозиторий

```bash
git clone https://github.com/zhelandovskiy-ka/task_management_system.git
cd task_management_system
```

### Шаг 2: Соберите и запустите Docker контейнеры

Для сборки и запуска приложения используйте следующую команду:

```bash
docker-compose up --build -d
```

Это поднимет все необходимые сервисы (приложение и базу данных) в контейнерах Docker.

### Шаг 3: Регистрация пользователя

После запуска системы необходимо зарегистрировать пользователя. Отправьте следующий JSON запрос на 
```bash
`http://localhost:8080/auth/sign-up`:
```
```json
{
    "email": "admin@mail.com",
    "password": "password"
}
```

Используйте команду `curl` или Postman для отправки POST запроса на URL:

```bash
http://localhost:8080/auth/sign-up
```

### Шаг 4: Авторизация пользователя

Для получения JWT токена необходимо авторизоваться, отправив POST запрос на `http://localhost:8080/auth/sign-in`:

```json
{
    "email": "admin@mail.com",
    "password": "password"
}
```

```bash
http://localhost:8080/auth/sign-in
```

В ответе вы получите JWT токен, который нужно использовать для доступа к защищенным API.

### Шаг 5: Доступ к API

Для доступа к API используйте полученный JWT токен. Включите его в заголовок Authorization всех запросов:

```
Authorization: Bearer <your_token>
```

### Swagger UI

Swagger UI доступен по следующему URL:

```bash
http://localhost:8080/swagger-ui/index.html
```

### Завершение работы

Чтобы остановить и удалить контейнеры Docker, используйте команду:

```bash
docker-compose down
```
