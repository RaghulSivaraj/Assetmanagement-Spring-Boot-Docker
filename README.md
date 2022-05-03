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
**Now execute below scripts**

``use `Assetmanagement`;

DROP TABLE IF EXISTS `Assethistory`;

DROP TABLE IF EXISTS `Asset`;

DROP TABLE IF EXISTS `Users`;

CREATE TABLE `Asset` (
`asset_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`asset_name` varchar(40) DEFAULT NULL,
`asset_type` varchar(40) DEFAULT NULL,
`quantity` int(11) DEFAULT NULL,
PRIMARY KEY (`asset_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `Users` (
`user_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`username` varchar(20) NOT NULL,
`quantity` int(11) DEFAULT NULL,
PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;``

CREATE TABLE `assethistory` (
`transaction_id` int(11) unsigned NOT NULL,
`asset_id` int(11) unsigned NOT NULL,
`user_id` int(11) unsigned NOT NULL,
`quantity` int(11) unsigned NULL,
`type` varchar(20) DEFAULT NULL,
`createdOn` date DEFAULT NULL,
PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

**Insert some values to table**

INSERT INTO `Asset` VALUES
(1,'RealEstate','Immovableproperty',01),
(2,'Stocks','Immovableproperty',10),
(3,'Bonds','Immovableproperty',20),
(4,'Car','Movableproperty',01);


INSERT INTO `Users` VALUES
(1,"Raghul",0),
(2,"Jeeva",0),
(3,"Praveen",0),
(4,"Pradhosh",0),
(5,"Prem",0);


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
Follow same steps to get into mysql container for creating tables

#### To stop the application
```
docker-compose down
```
