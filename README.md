# What You Will Build

This is a Spring boot application to create and manage workout plans/routines, 
look plans created by others, track progress, set goals, learn exercises etc.

## Building Application

### Prerequisites

Before you begin, ensure you have the following installed:

- **Docker**: For creating, managing, and running containerized applications. [Get Docker](https://docs.docker.com/get-docker/).
- **Docker Compose**: For defining and running multi-container Docker applications. [Install Docker Compose](https://docs.docker.com/compose/install/).

### Setup and Execution

Run the `setup.sh` script to build and start all the required services:

```bash
./docker/setup.sh
```

This script performs the following tasks:

1. Builds Docker images for the application and the PostgreSQL database.
2. Starts the defined services in `docker-compose.yml`.
3. Creates a Docker network for inter-container communication.
4. Initializes the database with schema and test data from `resources/db`.

#### Customizing Initial Data

Modify `resources/db/data.sql` to change the initial data loaded into the database.

## Application & Routing

### Accessing Services

Ensure the following ports are open:

- **5432**: PostgreSQL Database
- **5050**: pgAdmin
- **8000**: Keycloak
- **8080**: Main Application

Access the services using these URLs:

- **Application**: [http://localhost:8080](http://localhost:8080)
- **pgAdmin**: [http://localhost:5050](http://localhost:5050)
- **Keycloak**: [http://localhost:8000](http://localhost:8000)

### Credentials
- **pgAdmin** 
    - email: `admin@admin.com` 
    - password: `admin`
- **Keycloak**
    - username: `admin`
    - password: `admin`
- **Database**
    - username: `postgres`
    - password: `postgres`

### API Documentation

Api documentation can be accessed in URLs below:
- http://localhost:8080/swagger-ui/index.html
- http://localhost:8080/v3/api-docs

**Note**: All application endpoints except documentation are not accessible without a token, 
if you want to disable security you can edit `SecurityConfiguration` 
class and replace line `.anyRequest().authenticated()` with `.anyRequest().permitAll()`

### Cleaning Up

Use `cleanup.sh` to stop services and remove resources:

```bash
./docker/cleanup.sh
```

This will remove Docker containers, networks, volumes, and images.

**Note**: This action is irreversible and will delete all data in Docker volumes.

## Additional Information

For further configuration or troubleshooting, refer to Docker and Docker Compose documentation.
