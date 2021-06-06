CREATE  TABLE IF NOT EXISTS  `lords`(
    `id` int(10) NOT NULL auto_increment,
    `name` varchar (255) NOT NULL,
    `age` int(2) NOT NULL
);

CREATE TABLE IF NOT EXISTS `planets`(
    `id` int(10) NOT NULL  auto_increment,
    `name` varchar(255) NOT NULL,
    `lord_id` int(10)
);
