# stage 1 — Сборка и распаковка слоев Spring Boot
FROM eclipse-temurin:21-jdk-alpine as build
LABEL maintainer="Denis Kryzhanovskiy <den_dehbka@mail.ru>"
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf /app.jar)

# stage 2 — Сборка минимального финального образа для запуска
FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
EXPOSE 8086
ENTRYPOINT ["java","-cp","app:app/lib/*","com.dolsoft.disciplines_service.DisciplinesServiceApplication"]