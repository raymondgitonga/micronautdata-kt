FROM oracle/graalvm-ce:20.0.0-java8 as graalvm
# For JDK 11
#FROM oracle/graalvm-ce:20.0.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/micronautdata-kt
WORKDIR /home/app/micronautdata-kt

RUN native-image --no-server -cp build/libs/micronautdata-kt-*-all.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/micronautdata-kt/micronautdata-kt /app/micronautdata-kt
ENTRYPOINT ["/app/micronautdata-kt"]
