#删除数据库
drop database if exists mydb;

#创建数据库
CREATE DATABASE IF NOT EXISTS MyDB;

#选择数据库
use MyDB;

#创建用户表
CREATE TABLE IF NOT EXISTS Users(
   Car_Id VARCHAR(50) NOT NULL,
   Color VARCHAR(50),
   User_Name VARCHAR(50) NOT NULL,
   User_PassWord VARCHAR(50) NOT NULL,
   User_Phone VARCHAR(50) NOT NULL,
   Card_Type VARCHAR(50) DEFAULT 'Temporary',
   Card_Num VARCHAR(50),
   PRIMARY KEY (Car_Id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#创建车位表
CREATE TABLE IF NOT EXISTS Parking_Space(
   Space_Id INT UNSIGNED AUTO_INCREMENT,
   Space_Type VARCHAR(50) DEFAULT 'Temporary',
   Space_State VARCHAR(50) DEFAULT 'Spare',
   PRIMARY KEY (Space_Id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#创建费用表
CREATE TABLE IF NOT EXISTS Fee(
   Car_Id VARCHAR(50) NOT NULL,
   Parking_Fee FLOAT NOT NULL,
   PRIMARY KEY (Car_Id),
   FOREIGN KEY (Car_Id) REFERENCES Users(Car_Id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#############以上为基本表#####################
#创建专有车位表
CREATE TABLE IF NOT EXISTS Special(
   Car_Id VARCHAR(50) NOT NULL,
   Space_Id INT UNSIGNED NOT NULL,
   PRIMARY KEY (Car_Id),
   FOREIGN KEY (Car_Id) REFERENCES Users(Car_Id),
   FOREIGN KEY (Space_Id) REFERENCES Parking_Space(Space_Id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#创建预定信息表
CREATE TABLE IF NOT EXISTS Booking_information(
   Booking_Id INT UNSIGNED AUTO_INCREMENT,
   Space_Id INT UNSIGNED NOT NULL,
   Car_Id VARCHAR(50) NOT NULL,
   Booking_Time DATETIME NOT NULL,
   Arrival_Time DATETIME,
   Booking_Fee FLOAT DEFAULT 0.0,
   FOREIGN KEY (Space_Id) REFERENCES Parking_Space(Space_Id),
   FOREIGN KEY (Car_Id) REFERENCES Users(Car_Id),
   PRIMARY KEY (Booking_Id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#创建停车表
# 车费一开始可空，之后动态插入
CREATE TABLE IF NOT EXISTS Parking(
   Car_Id VARCHAR(50) NOT NULL,
   Space_Id INT UNSIGNED,
   Parking_Fee FLOAT DEFAULT 0.0,
   Arrival_Time DATETIME NOT NULL,
   PRIMARY KEY (Car_Id),
   FOREIGN KEY (Car_Id) REFERENCES Users(Car_Id),
   FOREIGN KEY (Space_Id) REFERENCES Parking_Space(Space_Id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#创建历史停车表
CREATE TABLE IF NOT EXISTS Parking_History(
   Car_Id VARCHAR(50) NOT NULL,
   Parking_Fee FLOAT NOT NULL,
   Booking_Fee FLOAT,
   Space_Id INT UNSIGNED,
   Arrival_Time DATETIME NOT NULL,
   Depature_Time DATETIME NOT NULL,
   PRIMARY KEY (Car_Id),
   FOREIGN KEY (Car_Id) REFERENCES Users(Car_Id),
   FOREIGN KEY (Space_Id) REFERENCES Parking_Space(Space_Id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 创建违规信息表
CREATE TABLE IF NOT EXISTS Violations(
   Violation_Id INT UNSIGNED AUTO_INCREMENT,
   Car_Id VARCHAR(50) NOT NULL,
   Violation_Count INT,
   Violation_Detail VARCHAR(100),
   PRIMARY KEY (Violation_Id),
   FOREIGN KEY (Car_Id) REFERENCES Users(Car_Id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


