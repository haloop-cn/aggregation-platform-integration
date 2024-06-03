#!/usr/bin/env bash

set -e

workdir=$(pwd)/../

cd "$workdir"
echo "正在打包服务端..."
mvn clean package -Dmaven.test.skip=true

echo "正在构建服务端镜像..."
cd agg-client-demo
docker build -t agg-integration-server .

cd "$workdir"

echo "正在打包前端..."
cd web
pnpm run build

echo "正在构建前端镜像..."
docker build -t agg-integration-web .

echo "正在导出镜像..."
docker save -o agg-integration-server.tar agg-integration-server
docker save -o agg-integration-web.tar agg-integration-web

echo "正在上传镜像..."
rsync -avz agg-integration-server.tar remote:~/agg/agg-integration-server.tar
rsync -avz agg-integration-web.tar remote:~/agg/agg-integration-web.tar

rm -f agg-integration-server.tar
rm -f agg-integration-web.tar

echo "正在部署服务..."
ssh remote "cd ~/agg && docker load -i agg-integration-server.tar && docker load -i agg-integration-web.tar && docker-compose -f docker-compose.yml.test up -d"

