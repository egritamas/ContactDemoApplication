
Contact Manager Demo Application
======

Installations steps

Docker
======
Docker version 25.0.3, build 4debf41

Postgres
======
postgres (PostgreSQL) 14.11


Liquibase
=======

Git repository




docker run --name postgres -e POSTGRES_PASSWORD=admin -d -p 5432:5432 -v ~/apps/postgres:/var/lib/postgresql14/data postgres:14-alpine

docker exec -it postgres /bin/sh

psql --username postgres

create database contacts;

[comment]: <> (create user cadmin;)

[comment]: <> (alter user cadmin password 'Test1234';)

[comment]: <> (grant all privileges on database contacts to cadmin;)

./mvnw liquibase:update
