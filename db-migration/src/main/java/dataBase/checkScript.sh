#!/bin/bash

DB_HOST=localhost
DB_PORT=5432
DB_NAME=air
DB_USER=air
DB_PASSWORD=air
SCHEMA_NAME=my_schema
command -v psql >/dev/null 2>&1 || { echo >&2 "Утилита psql не установлена. Установите пакет postgresql-client и повторите попытку."; exit 1; }
DB_CONNECTION="postgresql://${DB_USER}:${DB_PASSWORD}@${DB_HOST}:${DB_PORT}/${DB_NAME}"
if ! psql "${DB_CONNECTION}" -c "SELECT schema_name FROM information_schema.schemata WHERE schema_name = 'DB_CONNECTION" −c "SELECTschema name FROM information schema.schemata WHERE schema name=′{SCHEMA_NAME}'" | grep -q "${SCHEMA_NAME}";
then psql "${DB_CONNECTION}" -c "CREATE SCHEMADB CONNECTION CREATESCHEMA{SCHEMA_NAME}"echo "Схема ${SCHEMA_NAME} успешно создана"
fi