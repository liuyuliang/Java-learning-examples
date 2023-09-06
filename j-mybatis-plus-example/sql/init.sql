CREATE TABLE `user`
(
    `id` int(10) NOT NULL AUTO_INCREMENT,
    `user_name` varchar(30) NOT NULL,
    `password` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
