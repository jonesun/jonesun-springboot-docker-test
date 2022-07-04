运行./gradlew clean build和./gradlew test 以此来检查项目运行是否有问题

```shell
docker build -t ccr.ccs.tencentyun.com/jonesun/docker-test:0.0.1-SNAPSHOT .

# 后台方式
docker run -d -p 8081:8081 ccr.ccs.tencentyun.com/jonesun/docker-test:0.0.1-SNAPSHOT docker-test
docker run -d -p 8081:8081 --name docker-test ccr.ccs.tencentyun.com/jonesun/docker-test:0.0.1-SNAPSHOT docker-test

# 先登录 我这里使用的是腾讯云的镜像仓库
docker login --username=xxxxxx ccr.ccs.tencentyun.com

# 上传镜像
docker tag [imageId] ccr.ccs.tencentyun.com/jonesun/docker-test:[tag]
docker push ccr.ccs.tencentyun.com/jonesun/docker-test:[tag]

# 拉取镜像
docker pull ccr.ccs.tencentyun.com/jonesun/docker-test:[tag]

docker tag ccr.ccs.tencentyun.com/jonesun/docker-test:0.0.1-SNAPSHOT ccr.ccs.tencentyun.com/jonesun/docker-test:0.0.1-SNAPSHOT
docker push ccr.ccs.tencentyun.com/jonesun/docker-test:0.0.1-SNAPSHOT

./gradlew build
docker build -t ccr.ccs.tencentyun.com/jonesun/docker-test:latest .
docker tag ccr.ccs.tencentyun.com/jonesun/docker-test:latest ccr.ccs.tencentyun.com/jonesun/docker-test:latest
docker push ccr.ccs.tencentyun.com/jonesun/docker-test:latest

docker pull ccr.ccs.tencentyun.com/jonesun/docker-test:latest
```


sh start.sh
```shell
#!/bin/bash
echo "脚本执行开始"
docker pull ccr.ccs.tencentyun.com/jonesun/docker-test:latest

docker stop docker-test
docker rm docker-test
docker run --name docker-test -d -p 8081:8081 ccr.ccs.tencentyun.com/jonesun/docker-test:latest
#!/bin/bash
echo "脚本执行完毕"
```