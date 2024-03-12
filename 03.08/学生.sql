CREATE DATABASE teachManage;
USE teachManage;
CREATE TABLE IF NOT EXISTS `student`(
`sid` INT AUTO_INCREMENT PRIMARY KEY,
`sname` VARCHAR(20) NOT NULL,
`sbirth` VARCHAR(20) NOT NULL,
`ssex` VARCHAR(10) NOT NULL,
saccount VARCHAR(20) NOT NULL UNIQUE,
spass VARCHAR(20) NOT NULL,
saddress VARCHAR(30) NOT NULL
);

INSERT INTO `student`(sname,sbirth,ssex,saccount,spass,saddress) VALUES('赵雷','1990-01-01','男','zhaolei','123456','安徽合肥'); 
INSERT INTO `student`(sname,sbirth,ssex,saccount,spass,saddress) VALUES('钱电','1990-12-21','男','qiandian','123456','山东青岛'); 
INSERT INTO `student`(sname,sbirth,ssex,saccount,spass,saddress) VALUES('孙风','1990-05-20','男','sunfeng','123456','河南洛阳'); 
INSERT INTO `student`(sname,sbirth,ssex,saccount,spass,saddress) VALUES('李云','1990-08-06','男','liyun','123456','江苏盐城'); 
INSERT INTO `student`(sname,sbirth,ssex,saccount,spass,saddress) VALUES('周梅','1991-12-01','女','zhoumei','123456','安徽安庆'); 
INSERT INTO `student`(sname,sbirth,ssex,saccount,spass,saddress) VALUES('吴兰','1992-03-01','女','wulan','123456','上海'); 
INSERT INTO `student`(sname,sbirth,ssex,saccount,spass,saddress) VALUES('郑竹','1989-07-01','女','zhenzhu','123456','江苏南京'); 
INSERT INTO `student`(sname,sbirth,ssex,saccount,spass,saddress) VALUES('王菊','1990-01-20','女','wangju','123456','北京');