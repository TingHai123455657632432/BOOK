
CREATE TABLE IF NOT EXISTS manager(
`mid` VARCHAR(20) NOT NULL UNIQUE,
mpass VARCHAR(20) NOT NULL
);
INSERT INTO manager VALUES('master','123456');