
FROM openjdk:17-jdk-slim

# Указываем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем ваш JAR-файл в контейнер
COPY build/libs/toxum-bazari-backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080

# Команда, которая будет запущена при старте контейнера
ENTRYPOINT ["java", "-jar", "app.jar"]
