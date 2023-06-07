#!/bin/bash

set -e
set -u

function create_database() {
    local dbname=$1
    echo "Creating database: $dbname"
    psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
        CREATE DATABASE $dbname;
EOSQL
}

if [ -n "$POSTGRES_MULTIPLE_DATABASES" ]; then
    echo "Multiple database creation requested: $POSTGRES_MULTIPLE_DATABASES"
    IFS=',' read -ra dbs <<< "$POSTGRES_MULTIPLE_DATABASES"
    for db in "${dbs[@]}"; do
        create_database "$db"
    done
    echo "Multiple databases created"
fi
