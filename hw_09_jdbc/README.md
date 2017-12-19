# Homework 9
##### JDBC

Create a relation in database with following attributes:
- ```id bigint(20) NOT NULL auto_increment```
- ```name varchar(255)```
- ```age int(3)```

Create abstract class ```DataSet``` and add ```long id``` attribute. 

Add class ```UserDataSet``` (make sure that its attributes are identical
to the relation in database) and inherit it from ```DataSet```.

Write ```Executor``` that saves children of ```DataSet``` in database
and can extract them from database using their ```id``` and class.

- ```<T extends DataSet> void save (T user) {...}```
- ```<T extends DataSet> T load (long id, Class<T> clazz) {...}```

Make sure that ```Executor``` works with ```UserDataSet``` class.

##### Useful Docker commands:
- list images: ```docker images```
- list containers: ```docker container ls```
- fire up containers: ```docker-compose up -d```
- stop running containers: ```docker-compose stop```
- container shell access: ```docker exec -it my-mysql-db bash```

MySQL on Docker Hub: [mysql](https://hub.docker.com/r/_/mysql/)
