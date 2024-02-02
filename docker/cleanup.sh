#!/bin/bash

# Define the names of the images to be removed
APP_IMAGE_NAME="fitness-app"
POSTGRES_IMAGE_NAME="fitness-db"

# Stop and remove containers, networks, and volumes
echo "Stopping and removing containers, networks, and volumes..."
docker-compose -f compose.yaml -p fitness down -v

# Remove specific Docker images
echo "Removing Docker images..."
docker rmi "$APP_IMAGE_NAME" "$POSTGRES_IMAGE_NAME"

echo "Cleanup completed."
