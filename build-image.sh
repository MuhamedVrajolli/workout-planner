cd "$(dirname "$0")"

./gradlew clean build -x test -Dorg.gradle.java.home=/usr/lib/jvm/java-17-openjdk-amd64

docker build -t fitness-app .
