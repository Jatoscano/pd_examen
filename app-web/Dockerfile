# docker build -t app-books . ------------------> esto construye la imagen
# docker build -t jatoscano/app-books .   ------------------> esto construye la imagen y la etiqueta
# docker push jatoscano/app-books         ------------------> esto sube la imagen al repositorio

FROM eclipse-temurin:21.0.7_6-jre-noble

RUN mkdir /app
WORKDIR /app

COPY build/quarkus-app/lib ./lib
COPY build/quarkus-app/quarkus ./quarkus
COPY build/quarkus-app/app ./app
COPY build/quarkus-app/quarkus-run.jar app.jar

CMD ["java", "-jar", "app.jar"]