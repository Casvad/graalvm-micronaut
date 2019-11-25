
FROM gradle:jdk11 as builder
COPY --chown=gradle:gradle . /home/gradle/complete
WORKDIR /home/gradle/complete
RUN ./gradlew clean
RUN ./gradlew assemble -x test

FROM oracle/graalvm-ce:19.3.0 as graalvm
COPY --from=builder /home/gradle/complete /home/app/complete
WORKDIR /home/app/complete
RUN gu install native-image
RUN native-image --no-server -cp build/libs/complete-*-all.jar

FROM openjdk:8 as complete-application
EXPOSE 8080
COPY --from=graalvm /home/app/complete .
ENTRYPOINT ["./complete"]