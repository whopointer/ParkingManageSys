#ѡ�����ݿ�
use mydb;
#�����û���
#����10�����ÿ�
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("��A.11111","��ɫ","����","123","13011111111","permanent","A0001");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("��A.22222","��ɫ","����","123","13011112222","permanent","A0002");

INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("��A.33333","��ɫ","����","123","13011113333","permanent","A0003");

INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("��A.44444","��ɫ","����","123","13011114444","permanent","A0004");

INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("��A.55555","��ɫ","Ǯ����","123","13011115555","permanent","A0005");

INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("��A.66666","ש��ɫ","������","123","13011116666","permanent","A0006");

INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("��A.77777","������ɫ","������","123","13011117777","permanent","A0007");

INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("��A.88888","�ÿ�����ɫ","�׾���","123","13011118888","permanent","A0008");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("��A.99999","��ɫ","��Q","123","13011119999","permanent","A0009");

INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone,Card_Type,Card_Num)
                       VALUES
                       ("��A.12345","��ɫ","�������","123","13011110000","permanent","A0010");
# ����10����ʱ���û�
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("��A.21111","��ɫ","����","123","15011110000");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("��A.31111","��ɫ","����","123","15011111111");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("��A.41111","��ɫ","������","123","15011112222");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("��A.51111","��ɫ","���Գ�","123","15011113333");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("��A.61111","��ɫ","��Ԫ�","123","15011114444");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("��A.71111","��ɫ","����","123","15011115555");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("��A.81111","���ɫ","������","123","15011116666");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("��A.91111","ǳ��ɫ","��ʼ��","123","15011117777");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("��A.10111","��ɫ","����","123","15011118888");
INSERT INTO Users (Car_Id,Color,User_Name,User_PassWord,User_Phone)
                       VALUES
                       ("��A.43210","��ɫ","���","123","15011119999");
######################################################################################
# ���복λ��
#����10��ר�г�λ
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

# ����10�����г�λ
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
# ����ר�ó�λ��
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("��A.11111",1);
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("��A.22222",2);
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("��A.33333",3);
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("��A.44444",4);
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("��A.55555",5);
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("��A.66666",6);
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("��A.77777",7);
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("��A.88888",8);
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("��A.99999",9);
INSERT INTO Special (Car_Id,Space_Id)
                       VALUES
                       ("��A.12345",10);

##########################################################################################
# ����Ԥ����Ϣ��
# ����ʱҪ�ж�Space_Id��Ӧ��state�ǲ��ǿ���
# ����ʱ���Բ����뵽��ʱ���Ԥ�����ѣ���̬����

# ����Ԥ���ĳ��ѵ�����
INSERT INTO Booking_information(Space_Id,Car_Id,Booking_Time,Arrival_Time, Booking_Fee)
                       VALUES
                       (11,"��A.21111","2023-06-05 22:33:36","2023-06-05 23:33:36",12.3);
INSERT INTO Booking_information(Space_Id,Car_Id,Booking_Time,Arrival_Time, Booking_Fee)
                       VALUES
                       (12,"��A.31111","2023-06-06 22:33:36","2023-06-06 23:33:36",22);
INSERT INTO Booking_information(Space_Id,Car_Id,Booking_Time,Arrival_Time, Booking_Fee)
                       VALUES
                       (13,"��A.41111","2023-06-07 22:33:36","2023-06-07 23:33:36",15.3);
INSERT INTO Booking_information(Space_Id,Car_Id,Booking_Time,Arrival_Time, Booking_Fee)
                       VALUES
                       (14,"��A.51111","2023-06-08 22:33:36","2023-06-08 23:33:36",6.3);

#δ������
INSERT INTO Booking_information(Space_Id,Car_Id,Booking_Time)
                       VALUES
                       (15,"��A.61111","2023-06-08 22:33:36");
INSERT INTO Booking_information(Space_Id,Car_Id,Booking_Time)
                       VALUES
                       (16,"��A.71111","2023-06-08 22:33:36");
INSERT INTO Booking_information(Space_Id,Car_Id,Booking_Time)
                       VALUES
                       (17,"��A.81111","2023-06-08 22:33:36");


##########################################################################################

#����ͣ����
INSERT INTO Parking(Car_Id,Space_Id,Arrival_Time)
                       VALUES
                       ("��A.11111",1,"2023-06-08 22:33:36");
INSERT INTO Parking(Car_Id,Space_Id,Arrival_Time)
                       VALUES
                       ("��A.22222",2,"2023-06-08 22:33:36");

INSERT INTO Parking(Car_Id,Space_Id,Arrival_Time)
                       VALUES
                       ("��A.33333",3,"2023-06-08 22:33:36");

INSERT INTO Parking(Car_Id,Space_Id,Arrival_Time)
                       VALUES
                       ("��A.44444",4,"2023-06-08 22:33:36");
INSERT INTO Parking(Car_Id,Space_Id,Arrival_Time)
                       VALUES
                       ("��A.55555",5,"2023-06-08 22:33:36");

############################################################################################
#�������ñ�
INSERT INTO Fee(Car_Id,Parking_Fee)
                       VALUES
                       ("��A.11111",13.2);
INSERT INTO Fee(Car_Id,Parking_Fee)
                       VALUES
                       ("��A.22222",14.4);
INSERT INTO Fee(Car_Id,Parking_Fee)
                       VALUES
                       ("��A.33333",15.5);
INSERT INTO Fee(Car_Id,Parking_Fee)
                       VALUES
                       ("��A.44444",11);
INSERT INTO Fee(Car_Id,Parking_Fee)
                       VALUES
                       ("��A.55555",14);
###########################################################################################


# ����ʱ������ȥuser�������Ƿ�Ϊ���ÿ���Ϊ���ÿ����Զ���������
# �ж��Ƿ�Ϊר�ó�λ��Ϊר�ó�λ��Parking_Fee�� Booking_Fee����Ϊ0

INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("��A.11111",0,0,1,"2023-06-05 23:33:36","2023-06-06 23:33:36");
INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("��A.22222",0,0,2,"2023-07-05 15:33:36","2023-07-05 23:33:36");
INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("��A.33333",0,0,3,"2023-08-05 16:33:36","2023-08-06 23:33:36");
INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("��A.44444",0,0,4,"2023-09-05 23:33:36","2023-09-06 23:33:36");
INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("��A.55555",0,0,5,"2023-10-05 15:33:36","2023-10-06 23:33:36");

# ������ʱ����
INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("��A.21111",11,12,1,"2023-06-05 23:33:36","2023-06-06 23:33:36");
INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("��A.31111",13.5,0,2,"2023-07-05 15:33:36","2023-07-05 23:33:36");
INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("��A.41111",17.8,0,3,"2023-08-05 16:33:36","2023-08-06 23:33:36");
INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("��A.51111",14.2,0,4,"2023-09-05 23:33:36","2023-09-06 23:33:36");
INSERT INTO Parking_History(Car_Id,Parking_Fee,Booking_Fee,Space_Id,Arrival_Time,Depature_Time)
                       VALUES
                       ("��A.61111",28.6,13,5,"2023-10-05 15:33:36","2023-10-06 23:33:36");
################################################################################################
#����Υ����Ϣ

INSERT INTO Violations(Car_Id,Violation_Count,Violation_Detail)
                       VALUES
                       ("��A.61111",1,"ռ����������");
INSERT INTO Violations(Car_Id,Violation_Count,Violation_Detail)
                       VALUES
                       ("��A.51111",2,"��ͣ�ҷ�");
INSERT INTO Violations(Car_Id,Violation_Count,Violation_Detail)
                       VALUES
                       ("��A.41111",1,"����");
INSERT INTO Violations(Car_Id,Violation_Count,Violation_Detail)
                       VALUES
                       ("��A.31111",1,"����������Ա����");



















