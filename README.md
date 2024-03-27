#Contact Manager Demo Application

## Demo project for DPD


Software tools

- Docker version 25.0.3
- postgres (PostgreSQL) 14.11
- JAVA 17 Temurin
- Springboot 3.2.4
- Maven
- Linquibase
- Thymeleaf 
- Lombok

Git repository
https://github.com/egritamas/ContactDemoApplication.git

### Installations steps

Init database

1. Run postgres standalone
2.docker run --name postgres -e POSTGRES_PASSWORD=admin -d -p 5432:5432 -v ~/apps/postgres:/var/lib/postgresql14/data postgres:14-alpine
3. docker exec -it postgres /bin/sh
4. psql --username postgres
5. create database contacts;
6. Init database with sapmle data: ./mvnw liquibase:update
   - creates tables: contact, address, phone
   - add sample data for initial steps 
   
Init docker

7. Create docker image
   - docker image build -t hu.demo/contacts .
8. Run application
   - docker-compose up
   

Run

9. localhost:8080

### Screenshots

 Directory: /resources/static/images/screenshots