--ROLES table
INSERT INTO "ADMIN"."ROLE" (ID,CREATEDBY,CREATEDON,UPDATEDBY,UPDATEDON,NAME,VERSION) VALUES (1,null,{ts '2017-04-23 13:08:02.302000'},null,{ts '2017-04-23 13:08:02.302000'},'USER',0);
INSERT INTO "ADMIN"."ROLE" (ID,CREATEDBY,CREATEDON,UPDATEDBY,UPDATEDON,NAME,VERSION) VALUES (2,null,{ts '2017-04-23 13:08:09.276000'},null,{ts '2017-04-23 13:08:09.276000'},'DBA',0);
INSERT INTO "ADMIN"."ROLE" (ID,CREATEDBY,CREATEDON,UPDATEDBY,UPDATEDON,NAME,VERSION) VALUES (3,null,{ts '2017-04-23 13:08:13.750000'},null,{ts '2017-04-23 13:08:13.750000'},'ADMIN',0);
INSERT INTO "ADMIN"."ROLE" (ID,CREATEDBY,CREATEDON,UPDATEDBY,UPDATEDON,NAME,VERSION) VALUES (4,null,{ts '2017-04-23 13:08:19.689000'},null,{ts '2017-04-23 13:08:19.689000'},'OPERATOR',0);

-- USERS table
INSERT INTO "ADMIN"."XUSER" (ID,CREATEDBY,CREATEDON,UPDATEDBY,UPDATEDON,ACCOUNTEXPIRED,ACCOUNTLOCKED,CREDENTIALSEXPIRED,EMAIL,ENABLED,FIRSTNAME,LASTNAME,PASSWORD,USERNAME,VERSION) VALUES (1,'guest',{ts '2017-04-23 13:10:07.587000'},null,{ts '2017-04-23 13:10:07.587000'},0,0,0,'kbalaj25@ford.com',1,'Balaji','Krishnan','kbalaj25','kbalaj25',0);
INSERT INTO "ADMIN"."XUSER" (ID,CREATEDBY,CREATEDON,UPDATEDBY,UPDATEDON,ACCOUNTEXPIRED,ACCOUNTLOCKED,CREDENTIALSEXPIRED,EMAIL,ENABLED,FIRSTNAME,LASTNAME,PASSWORD,USERNAME,VERSION) VALUES (2,'guest',{ts '2017-04-23 13:10:34.673000'},null,{ts '2017-04-23 13:10:34.673000'},0,0,0,'shimansh@ford.com',1,'Himanshu','Sharma','shimansh','shimansh',0);
INSERT INTO "ADMIN"."XUSER" (ID,CREATEDBY,CREATEDON,UPDATEDBY,UPDATEDON,ACCOUNTEXPIRED,ACCOUNTLOCKED,CREDENTIALSEXPIRED,EMAIL,ENABLED,FIRSTNAME,LASTNAME,PASSWORD,USERNAME,VERSION) VALUES (3,'guest',{ts '2017-04-23 13:10:52.977000'},null,{ts '2017-04-23 13:10:52.977000'},0,0,0,'pchakrad@ford.com',1,'Chakradar','Padi','pchakrad','pchakrad',0);
INSERT INTO "ADMIN"."XUSER" (ID,CREATEDBY,CREATEDON,UPDATEDBY,UPDATEDON,ACCOUNTEXPIRED,ACCOUNTLOCKED,CREDENTIALSEXPIRED,EMAIL,ENABLED,FIRSTNAME,LASTNAME,PASSWORD,USERNAME,VERSION) VALUES (4,'guest',{ts '2017-04-23 13:11:27.470000'},null,{ts '2017-04-23 13:11:27.470000'},0,0,0,'kchockal@ford.com',1,'Chockkalingam','Kathiresan','kchockal','kchockal',0);
INSERT INTO "ADMIN"."XUSER" (ID,CREATEDBY,CREATEDON,UPDATEDBY,UPDATEDON,ACCOUNTEXPIRED,ACCOUNTLOCKED,CREDENTIALSEXPIRED,EMAIL,ENABLED,FIRSTNAME,LASTNAME,PASSWORD,USERNAME,VERSION) VALUES (5,'guest',{ts '2017-04-23 13:11:48.651000'},null,{ts '2017-04-23 13:11:48.651000'},0,0,0,'gvijay2@ford.com',1,'Vijay','Garudeshwar','gvijay2','gvijay2',0);
INSERT INTO "ADMIN"."XUSER" (ID,CREATEDBY,CREATEDON,UPDATEDBY,UPDATEDON,ACCOUNTEXPIRED,ACCOUNTLOCKED,CREDENTIALSEXPIRED,EMAIL,ENABLED,FIRSTNAME,LASTNAME,PASSWORD,USERNAME,VERSION) VALUES (6,'guest',{ts '2017-04-23 13:12:15.348000'},null,{ts '2017-04-23 13:12:15.348000'},0,0,0,'ipaulmut@ford.com',1,'Paul','Muthumani Selvan','ipaulmut','ipaulmut',0);
INSERT INTO "ADMIN"."XUSER" (ID,CREATEDBY,CREATEDON,UPDATEDBY,UPDATEDON,ACCOUNTEXPIRED,ACCOUNTLOCKED,CREDENTIALSEXPIRED,EMAIL,ENABLED,FIRSTNAME,LASTNAME,PASSWORD,USERNAME,VERSION) VALUES (7,'guest',{ts '2017-04-23 13:12:38.135000'},null,{ts '2017-04-23 13:12:38.135000'},0,0,0,'twaltern@ford.com',1,'Walter','Thavamani Nicho','twaltern','twaltern',0);

--USER ROLES Mapping
INSERT INTO "ADMIN"."USER_ROLE" (USER_ID,ROLE_ID) VALUES (1,4);
INSERT INTO "ADMIN"."USER_ROLE" (USER_ID,ROLE_ID) VALUES (1,3);
INSERT INTO "ADMIN"."USER_ROLE" (USER_ID,ROLE_ID) VALUES (1,2);
INSERT INTO "ADMIN"."USER_ROLE" (USER_ID,ROLE_ID) VALUES (1,1);
INSERT INTO "ADMIN"."USER_ROLE" (USER_ID,ROLE_ID) VALUES (2,3);
INSERT INTO "ADMIN"."USER_ROLE" (USER_ID,ROLE_ID) VALUES (2,1);
INSERT INTO "ADMIN"."USER_ROLE" (USER_ID,ROLE_ID) VALUES (3,2);
INSERT INTO "ADMIN"."USER_ROLE" (USER_ID,ROLE_ID) VALUES (3,1);
INSERT INTO "ADMIN"."USER_ROLE" (USER_ID,ROLE_ID) VALUES (4,4);
INSERT INTO "ADMIN"."USER_ROLE" (USER_ID,ROLE_ID) VALUES (4,3);
INSERT INTO "ADMIN"."USER_ROLE" (USER_ID,ROLE_ID) VALUES (4,1);
INSERT INTO "ADMIN"."USER_ROLE" (USER_ID,ROLE_ID) VALUES (5,2);
INSERT INTO "ADMIN"."USER_ROLE" (USER_ID,ROLE_ID) VALUES (5,1);
INSERT INTO "ADMIN"."USER_ROLE" (USER_ID,ROLE_ID) VALUES (6,1);
INSERT INTO "ADMIN"."USER_ROLE" (USER_ID,ROLE_ID) VALUES (7,1);

--PLACES table
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (1,'Chennai','India','CBMT terminus','Koyambedu','600107','TamilNadu');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (2,'Chennai','India','Near railway station','Tambaram','600046','TamilNadu');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (3,'Chennai','India','Kamarajar Statue','Perungalathur','600063','TamilNadu');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (4,'Chennai','India','Adjacent to A2B main branch','Adayar','600020','TamilNadu');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (5,'Chennai','India','Race course road','Guindy','600032','TamilNadu');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (6,'Chennai','India','Next to railway station','Saidapettai','600015','TamilNadu');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (7,'Chennai','India','Sholinganallur signal','Sholinganallur','600119','TamilNadu');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (8,'Chennai','India','Near kutt road junction','Medavakkam','601302','TamilNadu');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (9,'Chennai','India','Near Murugan temple','Vadapalani','600026','TamilNadu');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (10,'Coimbatore','India','Bus Depot','Gandhipuram','641012','TamilNadu');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (11,'Coimbatore','India','Hopes signal','Hopes College','641004','TamilNadu');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (12,'Coimbatore','India','Bus Depot','Thudiyalur','641034','TamilNadu');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (13,'Coimbatore','India','Near old bus stand','Ukkadam','641018','TamilNadu');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (14,'Coimbatore','India','near shanmuga theatre','Flower market','641018','TamilNadu');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (15,'Coimbatore','India','depot','Omni bus stand','641012','TamilNadu');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (16,'Bangaluru','India','depot','Kempegowda','560009','Karnataka');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (17,'Bangaluru','India','Bus Depot','Shanti Nagar','560027','Karnataka');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (18,'Bangaluru','India','Next to railway station','Majestic','560001','TamilNadu');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (19,'Bangaluru','India','Nearby airport','Hebbal','560024','Karnataka');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (20,'Salem','India','Near Hotel','Sevvapettai','636002','TamilNadu');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (21,'Erode','India','Nearby PSB mills','Erode Main','627152','TamilNadu');
INSERT INTO "ADMIN"."PLACE" (ID,CITY,COUNTRY,LANDMARK,LOCATION,PINCODE,STATE) VALUES (22,'Mysore','India','Near Rani temple','AST Complex','570002','Karnataka');


--OPERATOR
INSERT INTO "ADMIN"."BUSOPERATOR" (ID,CONTACTNAME,CONTACTNUMBER,EMAIL,HEADOFFICEADDRESS,NAME) VALUES (1,'komathi','420','kpn@gmail.com','AnnaSalai','KPN Travels');
INSERT INTO "ADMIN"."BUSOPERATOR" (ID,CONTACTNAME,CONTACTNUMBER,EMAIL,HEADOFFICEADDRESS,NAME) VALUES (2,'Sethu Madhav Rav','976347390','abt@gmail.com','Ram Nagar','ABTX Travels');
INSERT INTO "ADMIN"."BUSOPERATOR" (ID,CONTACTNAME,CONTACTNUMBER,EMAIL,HEADOFFICEADDRESS,NAME) VALUES (3,'Anbu','867349571','arc@gmail.com','Nehru Stadium','ARC Tours & Travels');

--BUS
INSERT INTO "ADMIN"."BUS" (ID,BUSTYPE,CHARGINGAVAILABLE,GPSTRACKINGAVAILABLE,MODEL,REGNUMBER,SEATCAPACITY,OWNINGENTITY_ID) VALUES (1,4,1,0,'Double Axel','TN 34 AJ2344',35,1);
INSERT INTO "ADMIN"."BUS" (ID,BUSTYPE,CHARGINGAVAILABLE,GPSTRACKINGAVAILABLE,MODEL,REGNUMBER,SEATCAPACITY,OWNINGENTITY_ID) VALUES (2,3,1,1,'VOLVO','TN 27 AJ8724',30,1);
INSERT INTO "ADMIN"."BUS" (ID,BUSTYPE,CHARGINGAVAILABLE,GPSTRACKINGAVAILABLE,MODEL,REGNUMBER,SEATCAPACITY,OWNINGENTITY_ID) VALUES (4,2,0,0,'NORMAL','TN 14 AJ2044',56,1);
INSERT INTO "ADMIN"."BUS" (ID,BUSTYPE,CHARGINGAVAILABLE,GPSTRACKINGAVAILABLE,MODEL,REGNUMBER,SEATCAPACITY,OWNINGENTITY_ID) VALUES (5,3,1,1,'VOLVO DOUBLE AXEL','KA 14 J82347',42,2);
INSERT INTO "ADMIN"."BUS" (ID,BUSTYPE,CHARGINGAVAILABLE,GPSTRACKINGAVAILABLE,MODEL,REGNUMBER,SEATCAPACITY,OWNINGENTITY_ID) VALUES (6,5,0,0,' NORMAL','TN 14 AW8196',56,2);
INSERT INTO "ADMIN"."BUS" (ID,BUSTYPE,CHARGINGAVAILABLE,GPSTRACKINGAVAILABLE,MODEL,REGNUMBER,SEATCAPACITY,OWNINGENTITY_ID) VALUES (7,2,0,0,'MULTI AXEL','KA 14 JR82348',56,2);
INSERT INTO "ADMIN"."BUS" (ID,BUSTYPE,CHARGINGAVAILABLE,GPSTRACKINGAVAILABLE,MODEL,REGNUMBER,SEATCAPACITY,OWNINGENTITY_ID) VALUES (8,4,1,0,'NORMAL','KA 21 BU7946',45,3);
INSERT INTO "ADMIN"."BUS" (ID,BUSTYPE,CHARGINGAVAILABLE,GPSTRACKINGAVAILABLE,MODEL,REGNUMBER,SEATCAPACITY,OWNINGENTITY_ID) VALUES (9,4,1,0,'NORMAL','TN 17 UH 5351',45,3);

--BUS STOPS
INSERT INTO "ADMIN"."BUSSTOP" (ID,ARRIVAL,DAY,DEPARTURE,OPERATOR_ID,PLACE_ID) VALUES (1,{t '20:00:00'},1,{t '20:15:00'},1,1);
INSERT INTO "ADMIN"."BUSSTOP" (ID,ARRIVAL,DAY,DEPARTURE,OPERATOR_ID,PLACE_ID) VALUES (2,{t '20:45:00'},1,{t '20:55:00'},1,9);
INSERT INTO "ADMIN"."BUSSTOP" (ID,ARRIVAL,DAY,DEPARTURE,OPERATOR_ID,PLACE_ID) VALUES (3,{t '21:30:00'},1,{t '21:45:00'},1,5);
INSERT INTO "ADMIN"."BUSSTOP" (ID,ARRIVAL,DAY,DEPARTURE,OPERATOR_ID,PLACE_ID) VALUES (4,{t '21:55:00'},1,{t '22:00:00'},1,6);
INSERT INTO "ADMIN"."BUSSTOP" (ID,ARRIVAL,DAY,DEPARTURE,OPERATOR_ID,PLACE_ID) VALUES (5,{t '22:30:00'},1,{t '22:35:00'},1,8);
INSERT INTO "ADMIN"."BUSSTOP" (ID,ARRIVAL,DAY,DEPARTURE,OPERATOR_ID,PLACE_ID) VALUES (6,{t '23:00:00'},1,{t '23:15:00'},1,2);
INSERT INTO "ADMIN"."BUSSTOP" (ID,ARRIVAL,DAY,DEPARTURE,OPERATOR_ID,PLACE_ID) VALUES (7,{t '23:45:00'},1,{t '23:55:00'},1,3);
INSERT INTO "ADMIN"."BUSSTOP" (ID,ARRIVAL,DAY,DEPARTURE,OPERATOR_ID,PLACE_ID) VALUES (8,{t '03:35:00'},2,{t '03:40:00'},1,20);
INSERT INTO "ADMIN"."BUSSTOP" (ID,ARRIVAL,DAY,DEPARTURE,OPERATOR_ID,PLACE_ID) VALUES (9,{t '04:30:00'},2,{t '04:35:00'},1,21);
INSERT INTO "ADMIN"."BUSSTOP" (ID,ARRIVAL,DAY,DEPARTURE,OPERATOR_ID,PLACE_ID) VALUES (10,{t '05:15:00'},2,{t '05:20:00'},1,22);
INSERT INTO "ADMIN"."BUSSTOP" (ID,ARRIVAL,DAY,DEPARTURE,OPERATOR_ID,PLACE_ID) VALUES (11,{t '06:00:00'},2,{t '06:10:00'},1,11);
INSERT INTO "ADMIN"."BUSSTOP" (ID,ARRIVAL,DAY,DEPARTURE,OPERATOR_ID,PLACE_ID) VALUES (12,{t '06:45:00'},2,{t '06:55:00'},1,10);
INSERT INTO "ADMIN"."BUSSTOP" (ID,ARRIVAL,DAY,DEPARTURE,OPERATOR_ID,PLACE_ID) VALUES (13,{t '09:00:00'},1,{t '09:15:00'},2,19);
INSERT INTO "ADMIN"."BUSSTOP" (ID,ARRIVAL,DAY,DEPARTURE,OPERATOR_ID,PLACE_ID) VALUES (14,{t '09:45:00'},1,{t '09:55:00'},2,16);
INSERT INTO "ADMIN"."BUSSTOP" (ID,ARRIVAL,DAY,DEPARTURE,OPERATOR_ID,PLACE_ID) VALUES (15,{t '11:11:00'},1,{t '11:12:00'},1,1);
INSERT INTO "ADMIN"."BUSSTOP" (ID,ARRIVAL,DAY,DEPARTURE,OPERATOR_ID,PLACE_ID) VALUES (16,{t '10:30:00'},1,{t '10:35:00'},2,17);
INSERT INTO "ADMIN"."BUSSTOP" (ID,ARRIVAL,DAY,DEPARTURE,OPERATOR_ID,PLACE_ID) VALUES (17,{t '11:15:00'},1,{t '11:45:00'},2,18);
INSERT INTO "ADMIN"."BUSSTOP" (ID,ARRIVAL,DAY,DEPARTURE,OPERATOR_ID,PLACE_ID) VALUES (18,{t '04:45:00'},2,{t '04:55:00'},2,10);