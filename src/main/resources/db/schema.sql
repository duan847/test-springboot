DROP TABLE IF EXISTS `test`.`student`;
CREATE TABLE `test`.`student` (
  `id` bigint(20) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `test`.`score`;
CREATE TABLE `test`.`score` (
  `id` bigint(20) NOT NULL,
  `course_name` varchar(32) DEFAULT NULL,
  `score` decimal(5,2) DEFAULT NULL,
  `student_id` bigint(20),
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `test`.`teacher`;
CREATE TABLE `test`.`teacher` (
  `id` bigint(20) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);
