## developing with Docker

Right-click on pom.xml →Run As → Maven build
or mvn clean and mvn install now you can see the created jar under target folder
```
 docker pull mysql:8.0.26
```
**Inside the Project folder**
```
docker build -t assetmanagement .
```
The dot "." at the end of the command denotes location of the Dockerfile.

**Verify whether images are created correctly**

```
docker images
```

**Now will have a docker network that contains both Spring-boot and MySQL containers and these containers will communicate with each other.**

```
docker network create assetmanagement-mysql
```
**verify it**
```
docker network ps

```
**Run Mysql container in network**
```
docker run --name mysqldb --network assetmanagement-mysql -e MYSQL_ROOT_PASSWORD=springstudent -e MYSQL_DATABASE=Assetmanagement -e MYSQL_USER=springstudent -e MYSQL_PASSWORD=springstudent -d mysql:8.0.26
```

**to create table we need to get into Mysql Container**

```
- docker exec -it <container_id> bash
- mysql -u<username> -p<password>
- show databases;
```
**Now execute SQL scripts **



**Run the Spring-boot container**

```
docker run --network  assetmanagement-mysql --name assetmanagement-container -p 8080:8080 -d assetmanagement
```

To see logs
```
docker logs -f <container_id> 
```
That’s all we need to do!.
Now head to postman to perform below operations

<img width="1012" alt="Screenshot 2022-05-03 at 1 39 57 PM" src="https://user-images.githubusercontent.com/62843185/166422107-75439b6b-6365-4eac-ae05-2c289a1f244c.png">

<img width="993" alt="Screenshot 2022-05-03 at 1 40 24 PM" src="https://user-images.githubusercontent.com/62843185/166422153-eed37f19-736a-4217-aee4-37290e3f4b4b.png">



### With Docker Compose

#### To start the application
```
docker-compose up
```
Follow same steps to get into mysql container and execute SQL scripts for creating tables

#### To stop the application
```
docker-compose down
```
