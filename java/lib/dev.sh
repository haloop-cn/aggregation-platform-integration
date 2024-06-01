#!/usr/bin/env bash

set -e

workdir=$(pwd)/../

echo "开始打包服务端..."
cd "$workdir"
mvn clean package

cd web
echo "开始打包前端..."
pnpm run build

cd "$workdir"
echo "构建镜像..."
docker-compose down && docker-compose up -d





