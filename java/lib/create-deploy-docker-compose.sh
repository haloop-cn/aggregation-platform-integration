#!/usr/bin/env bash

set -e

cat << EOF > docker-compose.yml
version: "3"
services:
  server:
    image: agg-integration-server
    container_name: agg-integration-server
    restart: always
    environment:
      SERVER_PORT: "8080"
    networks:
      - agg-network

  web:
    image: agg-integration-web
    container_name: agg-integration-web
    ports:
      - "80:80"
    restart: always
    networks:
      - agg-network

networks:
  agg-network:
    driver: bridge

EOF
