#!/bin/bash
set -e
echo "Leanpay assignment"
echo "************************************************"
echo "Build process start"
mvn install -P docker-build
echo "************************************************"
echo "Build process end"
echo "************************************************"
echo "*"

echo "Starting up the docker containers"
docker-compose up -d