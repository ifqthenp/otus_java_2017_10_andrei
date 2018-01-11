# Homework 10 
##### Hibernate

- Arrange the solution in the form of ```DBService``` (```interface DBService```,
```class DBServiceImpl```, ```UserDataSet```, etc) 
- Add into ```UserDataSet``` following fields:
    - address (OneToOne)
    - phone number (OneToMany)

##### Useful Docker commands:
- list images: ```docker images```
- list containers: ```docker container ls```
- fire up containers: ```docker-compose up -d```
- stop running containers: ```docker-compose stop```
- container shell access: ```docker exec -it my-mysql-db bash```

MySQL on Docker Hub: [mysql](https://hub.docker.com/r/_/mysql/)
