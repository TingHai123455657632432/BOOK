USE teachManage;
CREATE TABLE IF NOT EXISTS `teacher`(
`tid` INT AUTO_INCREMENT PRIMARY KEY,
`tname` VARCHAR(20) NOT NULL,
tphone VARCHAR(15) NOT NULL,
taccount VARCHAR(20) UNIQUE NOT NULL,
tpass VARCHAR(20) NOT NULL
);

INSERT INTO `teacher`(tname,tphone,taccount,tpass) VALUES('张三','12345678909','zhangsan','123456'); 
INSERT INTO `teacher`(tname,tphone,taccount,tpass) VALUES('李四','13245648036','lisi','123456'); 
INSERT INTO `teacher`(tname,tphone,taccount,tpass) VALUES('王五','32543523255','wangwu','123456');