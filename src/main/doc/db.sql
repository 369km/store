CREATE TABLE `buy_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT current_timestamp(),
  `creator_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `specs` varchar(100) NOT NULL,
  `buy_price` decimal(10,0) NOT NULL,
  `sell_price` decimal(10,0) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT current_timestamp(),
  `modify_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `goods_name_IDX` (`name`,`specs`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `sell_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT current_timestamp(),
  `creator_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

CREATE TABLE `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NOT NULL,
  `total` bigint(20) NOT NULL DEFAULT 0,
  `remains` bigint(20) NOT NULL DEFAULT 0,
  `sells` bigint(20) DEFAULT 0,
  `cost` decimal(10,0) NOT NULL DEFAULT 0,
  `profit` decimal(10,0) DEFAULT 0,
  `create_time` datetime NOT NULL DEFAULT current_timestamp(),
  `modify_time` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

CREATE TABLE `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `weichat` varchar(20) DEFAULT '',
  `phone` varchar(11) NOT NULL,
  `address` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT current_timestamp(),
  `modify_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(100) NOT NULL,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_IDX` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
