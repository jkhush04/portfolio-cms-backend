# Portfolio CMS — Backend

Custom-built CMS backend (Spring Boot 3 + Java 21 + MongoDB). Serves REST APIs
consumed by both the public portfolio site and the admin panel (both live in
the separate `portfolio-cms-frontend` Next.js project).

## Prerequisites

- Java 21 (you already have this from TaskFlow API)
- Maven 3.9+ (already installed)
- MongoDB running locally, OR a free MongoDB Atlas cluster

### Option A: MongoDB via Docker (recommended, matches your existing Docker setup)

```bash
docker run -d --name portfolio-mongo -p 27017:27017 mongo:7
```

### Option B: MongoDB Atlas (free cloud cluster, no local install)

Create a free cluster at mongodb.com/atlas, get the connection string, then run
the app with:

```bash
MONGODB_URI="your-atlas-connection-string" ./mvnw spring-boot:run
```

## Running locally

```bash
cd portfolio-cms-backend
./mvnw spring-boot:run
```

Then check it's alive:

```bash
curl http://localhost:8080/api/health
# {"status":"UP","service":"portfolio-cms-backend"}
```

## What's built so far

**Day 1**
- Maven project with Spring Web, Spring Data MongoDB, Spring Security, JJWT,
  Lombok, Validation
- MongoDB connection wired via `application.yml` (reads `MONGODB_URI` env var,
  defaults to local Mongo)
- `/api/health` endpoint to confirm the app boots and is reachable
- Layered package structure:
  `config / controller / dto / exception / model / repository / security / service`

**Day 2 — Admin user + JWT login**
- `AdminUser` MongoDB document (username + BCrypt password hash)
- `AdminSeeder`: on every startup, auto-creates one admin account from
  `ADMIN_USERNAME` / `ADMIN_PASSWORD` env vars if it doesn't exist yet —
  there is no public registration endpoint (single-admin CMS)
- `JwtService`: generates/validates stateless JWTs (HS256)
- `JwtAuthFilter`: reads `Authorization: Bearer <token>` on every request
- `SecurityConfig`: `/api/health`, `/auth/login`, and all `GET /api/**`
  (public content reads for the portfolio site) are open; everything else
  (admin writes) requires a valid JWT. Also configures CORS for two
  separate frontend origins (public site + admin panel)
- `POST /auth/login` — returns a JWT if username/password match

### Try it

```bash
# 1. Set your own admin credentials (or rely on the defaults: admin / changeme123)
export ADMIN_USERNAME=youradminname
export ADMIN_PASSWORD=your-strong-password

./mvnw spring-boot:run
```

Then log in:

```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"youradminname","password":"your-strong-password"}'
```

You should get back `{"token":"eyJ...", "username":"youradminname"}`.
Confirm the token actually works by hitting a protected endpoint (once Day 3
adds content APIs) with `Authorization: Bearer <token>`.

## Not built yet (upcoming days)

- Day 3: Content models (About, Skills, Projects, etc.) + CRUD APIs
- Day 4: File upload
- Day 5+: Frontend (Next.js) + separate Admin panel (Next.js) + deployment
