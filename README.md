运行./gradlew clean build和./gradlew test 以此来检查项目运行是否有问题

docker build -t io.github.jonesun/docker-test:0.0.1-SNAPSHOT .

docker run -p 8081:8081 io.github.jonesun/docker-test:0.0.1-SNAPSHOT