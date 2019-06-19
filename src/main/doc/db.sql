CREATE TABLE IF NOT EXISTS store.`user`
(
    id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    password varchar(100) NOT NULL,
    name     varchar(10)  NOT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8
    COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS store.`goods`
(
    id         INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name       varchar(10)  NOT NULL,
    specs      varchar(100) NOT NULL,
    buy_price  DECIMAL      NOT NULL,
    sell_price DECIMAL      NOT NULL,
    create_time DATETIME NOT NULL,
    creator_id INT NOT NULL,
    modify_time DATETIME NOT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8
    COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS store.`supplier`
(
    id      INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name    varchar(10) NOT NULL,
    weichat varchar(20) NULL,
    phone   varchar(11) NOT NULL,
    address varchar(50) NOT NULL,
    create_time DATETIME NOT NULL,
    creator_id INT NOT NULL,
    modify_time DATETIME NOT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8
    COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS store.`stock`
(
    id       INT     NOT NULL AUTO_INCREMENT PRIMARY KEY,
    goods_id INT     NOT NULL,
    total    BIGINT  NOT NULL,
    remains  BIGINT  NOT NULL,
    sells    BIGINT  NOT NULL,
    cost     DECIMAL NOT NULL,
    profit   DECIMAL NOT NULL,
    create_time DATETIME NOT NULL,
    creator_id INT NOT NULL,
    goods_name varchar(10) NOT NULL,
    modify_time DATETIME NOT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8
    COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS store.`buy_goods`
(
    id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    goods_id INT NOT NULL,
    amount   INT NOT NULL,
    create_time DATETIME NOT NULL,
    creator_id INT NOT NULL,
    modify_time DATETIME NOT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8
    COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS store.`sell_goods`
(
    id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    goods_id INT NOT NULL,
    amount   INT NOT NULL,
    create_time DATETIME NOT NULL,
    creator_id INT NOT NULL,
    modify_time DATETIME NOT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8
    COLLATE = utf8_general_ci;
