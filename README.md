
## Running Locally

**Prerequisites:** Java 21, Maven, MongoDB running locally (or Atlas).

```bash
docker run -d --name portfolio-mongo -p 27017:27017 mongo:7
```

Set the required environment variables (see below), then:

```bash
./mvnw spring-boot:run
```

Health check: `GET http://localhost:8080/api/health`

## Environment Variables

None of these have real values in this repo — see `ENV_VARS.md` for the
full list and what each one is for. Set them as actual environment
variables (locally via your IDE's run configuration, or on your hosting
platform's dashboard in production) — never commit real secrets.

## API Overview

| Method | Endpoint | Auth |
|---|---|---|
| GET | `/api/health` | public |
| POST | `/auth/login` | public |
| GET | `/api/about`, `/api/skills`, `/api/projects`, `/api/experience`, `/api/blogs`, `/api/testimonials`, `/api/services` | public |
| POST/PUT/DELETE | same paths as above | admin (JWT) |
| POST | `/api/upload/image` | admin (JWT) |
| POST | `/contact` | public |

## Deployment
Deployed on [Render/Railway — fill in once live]. See `ENV_VARS.md` for
production configuration.