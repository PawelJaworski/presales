FROM oracle/graalvm-ce:20.1.0-java8 as graalvm
RUN gu install native-image

COPY . /home/app/project-micronaut-app
WORKDIR /home/app/project-micronaut-app

RUN native-image --no-server -cp target/project-micronaut-app-*.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/project-micronaut-app/project-micronaut-app /app/project-micronaut-app
ENTRYPOINT ["/app/project-micronaut-app"]
