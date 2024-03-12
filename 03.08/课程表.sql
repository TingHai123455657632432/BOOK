CREATE TABLE IF NOT EXISTS `course`(
`cid` INT PRIMARY KEY AUTO_INCREMENT,
`cname` VARCHAR(20) NOT NULL,
`tid` INT NOT NULL UNIQUE
);

INSERT INTO `course` VALUES(1 , 'Java' , 2); 
INSERT INTO `course` VALUES(2, '大数据' , 1); 
INSERT INTO `course` VALUES(3 , '前端' , 3);
