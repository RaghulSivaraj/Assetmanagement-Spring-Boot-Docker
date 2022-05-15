use `Assetmanagement`;

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
