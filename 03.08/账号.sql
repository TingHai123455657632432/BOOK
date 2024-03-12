USE teach;
CREATE TABLE IF NOT EXISTS account (
sid VARCHAR(20) NULL UNIQUE,
spassword VARCHAR(20) NULL UNIQUE,
tid VARCHAR(20) NULL UNIQUE,
tpassword VARCHAR(20) NULL UNIQUE,
`mid` VARCHAR(20) NULL UNIQUE,
mpassword VARCHAR(20) NULL UNIQUE,
FOREIGN KEY (sid) REFERENCES student(sid),
FOREIGN KEY (tid) REFERENCES teacher(tid),
FOREIGN KEY (`mid`) REFERENCES manager(`mid`),
FOREIGN KEY (spassword) REFERENCES student(spass),
FOREIGN KEY (tpassword) REFERENCES teacher(tpass),
FOREIGN KEY (mpassword) REFERENCES manager(mpass)
);
