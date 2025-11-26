## Setting up MySQL Database

This document is more of a series of helpful command that might assist on setting up a MySQL Database and Java Server later on, rather than a step by step guide, hence the non-ordered list of commands.

### Execute MySQL:
```
sudo mysql
```

### Create a Database:
```
CREATE DATABASE mock_data;
```

### Create User and Grant Permission:
PS: Make sure to change your user accordingly when setting up connection 
```
CREATE USER 'user'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON mock_data.* TO 'user'@'localhost';
```

In case you want to check if the user exists, you may use:
```
SELECT host, user FROM mysql.user;
```

### Create table:
```
USE mock_data;
CREATE TABLE users (
id INT AUTO_INCREMENT,
name VARCHAR(255),
age INT,
PRIMARY KEY(id));
```

### Add values and check the entries:
```
INSERT INTO users (name, age) VALUES ("Tiffa", 35);
SELECT * FROM users;
```

### Check MySQL ports:
```
SHOW GLOBAL VARIABLES LIKE 'PORT';
```
