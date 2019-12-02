FROM oracle/graalvm-ce:19.3.0 as graalvm
COPY . /home/app/complete
WORKDIR /home/app/complete
RUN gu install native-image
RUN native-image --no-server -cp build/libs/complete-*-all.jar

FROM openjdk:11 as application
EXPOSE 8080
COPY --from=graalvm /home/app/complete .
ENTRYPOINT ["./complete"]