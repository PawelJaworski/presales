FROM oracle/graalvm-ce:20.1.0-java8 as graalvm
RUN gu install native-image

COPY . /home/app/wbsdiagram
WORKDIR /home/app/wbsdiagram

RUN native-image --no-server -cp target/wbsdiagram-*.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/wbsdiagram/wbsdiagram /app/wbsdiagram
ENTRYPOINT ["/app/wbsdiagram"]
