#!/bin/bash

# Function to clean up resources
cleanup() {
    echo "An error occurred. Cleaning up..."
    docker-compose -f compose.yaml down -v
    exit 1
}

# Trap any error signals (ERR) and call the cleanup function
trap 'cleanup' ERR

echo "Building App Image..."
docker build -f Dockerfile_app -t fitness-app ../

echo "Building PostgreSQL Image..."
docker build -f Dockerfile_postgres -t fitness-db ../

# Start services using docker-compose
echo "Starting services with Docker Compose..."
docker-compose -f compose.yaml -p fitness up -d

echo "Setup completed successfully."
