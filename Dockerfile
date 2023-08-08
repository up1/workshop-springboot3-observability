FROM ghcr.io/graalvm/jdk-community:17
WORKDIR /app
COPY . .
RUN gradlew nativeCompile
CMD build/native/nativeCompile/observability