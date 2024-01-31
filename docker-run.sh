#!/bin/bash
set -e

DOCKER_BRIDGE=`ip -4 -o addr | grep docker | awk '{split($4, a, "/"); print a[1]}'`

docker run --name spring-boot-template -p 8080:8080 -d \
           -e SPRING_DATASOURCE_URL="jdbc:postgresql://$DOCKER_BRIDGE/postgres" \
           -e SPRING_DATASOURCE_USERNAME="postgres" \
           -e SPRING_DATASOURCE_PASSWORD="postgres" \
           spring-boot-template:latest

docker logs -f spring-boot-template