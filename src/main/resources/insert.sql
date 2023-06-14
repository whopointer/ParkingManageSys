#选择数据库
use mydb;
#插入用户表
#插入10条永久卡
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("苏A.11111","红色","张三","123","13011111111","permanent","A0001");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("苏A.22222","白色","李四","123","13011112222","permanent","A0002");

INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("苏A.33333","蓝色","王五","123","13011113333","permanent","A0003");

INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("苏A.44444","绿色","赵六","123","13011114444","permanent","A0004");

INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("苏A.55555","彩色","钱老三","123","13011115555","permanent","A0005");

INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("苏A.66666","砖红色","高老四","123","13011116666","permanent","A0006");

INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("苏A.77777","五颜六色","王老五","123","13011117777","permanent","A0007");

INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("苏A.88888","好看的颜色","白举人","123","13011118888","permanent","A0008");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("苏A.99999","白色","阿Q","123","13011119999","permanent","A0009");

INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("苏A.12345","蓝色","假洋鬼子","123","13011110000","permanent","A0010");
# 插入10条临时卡用户
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("苏A.21111","白色","老张","123","15011110000");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("苏A.31111","蓝色","老李","123","15011111111");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("苏A.41111","红色","王自在","123","15011112222");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("苏A.51111","蓝色","李自成","123","15011113333");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("苏A.61111","绿色","朱元璋","123","15011114444");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("苏A.71111","黄色","康熙","123","15011115555");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("苏A.81111","金黄色","武则天","123","15011116666");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("苏A.91111","浅蓝色","秦始皇","123","15011117777");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("苏A.10111","蓝色","苏轼","123","15011118888");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("苏A.43210","黑色","苏洵","123","15011119999");
######################################################################################
# 插入车位表
#插入10条专有车位
INSERT INTO Parking_Space(Space_Type,Space_State)
                       VALUES
                       ("Permanent","Busy");
INSERT INTO Parking_Space(Space_Type,Space_State)
                       VALUES
                       ("Permanent","Busy");
INSERT INTO Parking_Space(Space_Type,Space_State)
                       VALUES
                       ("Permanent","Busy");
INSERT INTO Parking_Space(Space_Type,Space_State)
                       VALUES
                       ("Permanent","Busy");
INSERT INTO Parking_Space(Space_Type,Space_State)
                       VALUES
                       ("Permanent","Busy");
INSERT INTO Parking_Space(Space_Type,Space_State)
                       VALUES
                       ("Permanent","Busy");
INSERT INTO Parking_Space(Space_Type,Space_State)
                       VALUES
                       ("Permanent","Busy");
INSERT INTO Parking_Space(Space_Type,Space_State)
                       VALUES
                       ("Permanent","Busy");
INSERT INTO Parking_Space(Space_Type,Space_State)
                       VALUES
                       ("Permanent","Busy");
INSERT INTO Parking_Space(Space_Type,Space_State)
                       VALUES
                       ("Permanent","Busy");

# 插入10条空闲车位
INSERT INTO Parking_Space(Space_Type)
		       VALUES
                       ("Temporary");
INSERT INTO Parking_Space(Space_Type)
		       VALUES
                       ("Temporary");
INSERT INTO Parking_Space(Space_Type)
		       VALUES
                       ("Temporary");
INSERT INTO Parking_Space(Space_Type)
		       VALUES
                       ("Temporary");
INSERT INTO Parking_Space(Space_Type)
		       VALUES
                       ("Temporary");
INSERT INTO Parking_Space(Space_Type)
		       VALUES
                       ("Temporary");
INSERT INTO Parking_Space(Space_Type)
		       VALUES
                       ("Temporary");
INSERT INTO Parking_Space(Space_Type)
		       VALUES
                       ("Temporary");
INSERT INTO Parking_Space(Space_Type)
		       VALUES
                       ("Temporary");
INSERT INTO Parking_Space(Space_Type)
		       VALUES
                       ("Temporary");
######################################################################################
# 插入专用车位表
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("苏A.11111",1);
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("苏A.22222",2);
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("苏A.33333",3);
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("苏A.44444",4);
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("苏A.55555",5);
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("苏A.66666",6);
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("苏A.77777",7);
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("苏A.88888",8);
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("苏A.99999",9);
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("苏A.12345",10);

##########################################################################################
# 插入预定信息表
# 插入时要判断Space_Id对应的state是不是空闲
# 插入时可以不插入到达时间和预定花费，动态插入

# 假设预定的车已到场：
INSERT INTO Booking_information(Space_Id,Car_Id,Booking_Time,Arrival_Time, Booking_Fee)
                       VALUES
                       (11,"苏A.21111","2023-06-05 22:33:36","2023-06-05 23:33:36",12.3);
INSERT INTO Booking_information(Space_Id,Car_Id,Booking_Time,Arrival_Time, Booking_Fee)
                       VALUES
                       (12,"苏A.31111","2023-06-06 22:33:36","2023-06-06 23:33:36",22);
INSERT INTO Booking_information(Space_Id,Car_Id,Booking_Time,Arrival_Time, Booking_Fee)
                       VALUES
                       (13,"苏A.41111","2023-06-07 22:33:36","2023-06-07 23:33:36",15.3);
INSERT INTO Booking_information(Space_Id,Car_Id,Booking_Time,Arrival_Time, Booking_Fee)
                       VALUES
                       (14,"苏A.51111","2023-06-08 22:33:36","2023-06-08 23:33:36",6.3);

#未到场：
INSERT INTO Booking_information(Space_Id,Car_Id,Booking_Time)
                       VALUES
                       (15,"苏A.61111","2023-06-08 22:33:36");
INSERT INTO Booking_information(Space_Id,Car_Id,Booking_Time)
                       VALUES
                       (16,"苏A.71111","2023-06-08 22:33:36");
INSERT INTO Booking_information(Space_Id,Car_Id,Booking_Time)
                       VALUES
                       (17,"苏A.81111","2023-06-08 22:33:36");


##########################################################################################

#创建停车表
INSERT INTO Parking(Car_Id,Space_Id,Arrival_Time)
                       VALUES
                       ("苏A.11111",1,"2023-06-08 22:33:36");
INSERT INTO Parking(Car_Id,Space_Id,Arrival_Time)
                       VALUES
                       ("苏A.22222",2,"2023-06-08 22:33:36");

INSERT INTO Parking(Car_Id,Space_Id,Arrival_Time)
                       VALUES
                       ("苏A.33333",3,"2023-06-08 22:33:36");

INSERT INTO Parking(Car_Id,Space_Id,Arrival_Time)
                       VALUES
                       ("苏A.44444",4,"2023-06-08 22:33:36");
INSERT INTO Parking(Car_Id,Space_Id,Arrival_Time)
                       VALUES
                       ("苏A.55555",5,"2023-06-08 22:33:36");

############################################################################################
#创建费用表
INSERT INTO Fee(Car_Id,Parking_Fee)
                       VALUES
                       ("苏A.11111",13.2);
INSERT INTO Fee(Car_Id,Parking_Fee)
                       VALUES
                       ("苏A.22222",14.4);
INSERT INTO Fee(Car_Id,Parking_Fee)
                       VALUES
                       ("苏A.33333",15.5);
INSERT INTO Fee(Car_Id,Parking_Fee)
                       VALUES
                       ("苏A.44444",11);
INSERT INTO Fee(Car_Id,Parking_Fee)
                       VALUES
                       ("苏A.55555",14);
###########################################################################################


# 插入时可以先去user表里找是否为永久卡，为永久卡则自动插入数据
# 判断是否为专用车位，为专用车位则将Parking_Fee和 Booking_Fee设置为0

INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("苏A.11111",0,0,1,"2023-06-05 23:33:36","2023-06-06 23:33:36");
INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("苏A.22222",0,0,2,"2023-07-05 15:33:36","2023-07-05 23:33:36");
INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("苏A.33333",0,0,3,"2023-08-05 16:33:36","2023-08-06 23:33:36");
INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("苏A.44444",0,0,4,"2023-09-05 23:33:36","2023-09-06 23:33:36");
INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("苏A.55555",0,0,5,"2023-10-05 15:33:36","2023-10-06 23:33:36");

# 插入临时车主
INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("苏A.21111",11,12,1,"2023-06-05 23:33:36","2023-06-06 23:33:36");
INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("苏A.31111",13.5,0,2,"2023-07-05 15:33:36","2023-07-05 23:33:36");
INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("苏A.41111",17.8,0,3,"2023-08-05 16:33:36","2023-08-06 23:33:36");
INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("苏A.51111",14.2,0,4,"2023-09-05 23:33:36","2023-09-06 23:33:36");
INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("苏A.61111",28.6,13,5,"2023-10-05 15:33:36","2023-10-06 23:33:36");
################################################################################################
#插入违规信息

INSERT INTO Violations(Car_Id,Violation_Count,Violation_Detail)
                       VALUES
                       ("苏A.61111",1,"占用消防车道");
INSERT INTO Violations(Car_Id,Violation_Count,Violation_Detail)
                       VALUES
                       ("苏A.51111",2,"乱停乱放");
INSERT INTO Violations(Car_Id,Violation_Count,Violation_Detail)
                       VALUES
                       ("苏A.41111",1,"超速");
INSERT INTO Violations(Car_Id,Violation_Count,Violation_Detail)
                       VALUES
                       ("苏A.31111",1,"妨碍工作人员工作");



















