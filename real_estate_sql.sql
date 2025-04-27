show databases;
create database office_2;
use office_2;
show tables;

create table Owners(
Owner_ID int primary key,
Name varchar(30),
Phone_number numeric(10,0),
Email varchar(30)
);

create table Properties(
Property_ID int primary key,
Status varchar(10),
Asking_price int,
Address varchar(30),
Pin_code int,
Size_sq_feet numeric(5,2),
BHK int,
Property_type varchar(20),
Rent_per_month int,
Owner_ID int,
check(Status in("available", "rent", "sold")),
foreign key (Owner_ID) references Owners(Owner_ID)
);

ALTER TABLE Properties
MODIFY COLUMN Size_sq_feet int;

create table clients(
Client_Id int primary key,
Name varchar(30),
Phone_Number numeric(10,0),
Address varchar(30),
Email varchar(30)
);

create table Agent(
Agent_ID int primary key,
Name varchar(30),
Email varchar(30),
Phone_number numeric(10,0)
);

create table transaction(
Transcation_ID int primary key,
Date DATE,
Property_ID int,
Agent_ID int,
Client_ID int,
Owner_ID int,
Final_Price int,
Transaction_type varchar(20),
check (Transaction_type in("Sold", "Rent")),
foreign key (Property_ID) references Properties(Property_Id),
foreign key (Owner_id) references Owners(Owner_ID),
foreign key (Agent_ID) references Agent(Agent_Id),
foreign key (Client_Id) references Clients(Client_Id)
); 

desc Owners;
desc Properties;
desc Clients;
desc agent;
desc transaction;

insert into Owners (Owner_ID, Name, Email, Phone_number) values (1, 'Wain MacFie', 'wmacfie0@hhs.gov', 5177175477);
insert into Owners (Owner_ID, Name, Email, Phone_number) values (2, 'Lizbeth Layland', 'llayland1@com.com', 5914139423);
insert into Owners (Owner_ID, Name, Email, Phone_number) values (3, 'Corny Espadas', 'cespadas2@goo.ne.jp', 7589698126);
insert into Owners (Owner_ID, Name, Email, Phone_number) values (4, 'Far Orto', 'forto3@about.me', '182 512 6874');
insert into Owners (Owner_ID, Name, Email, Phone_number) values (5, 'Francesco Charpling', 'fcharpling4@cnbc.com', 7358023171);
insert into Owners (Owner_ID, Name, Email, Phone_number) values (6, 'Burtie Swaisland', 'bswaisland5@newyorker.com', 4085931753);
insert into Owners (Owner_ID, Name, Email, Phone_number) values (7, 'Hertha Tinwell', 'htinwell6@wordpress.com', 7912965720);
insert into Owners (Owner_ID, Name, Email, Phone_number) values (8, 'Dani Greenhill', 'dgreenhill7@hp.com', 7979913050);
insert into Owners (Owner_ID, Name, Email, Phone_number) values (9, 'Gustaf Wyleman', 'gwyleman8@baidu.com', 5714915364);
insert into Owners (Owner_ID, Name, Email, Phone_number) values (10, 'Stacee Czajkowski', 'sczajkowski9@si.edu', 2698849487);
insert into Owners (Owner_ID, Name, Email, Phone_number) values (11, 'Alika Gainfort', 'againfort0@liveinternet.ru', 1724783846);
insert into Owners (Owner_ID, Name, Email, Phone_number) values (12, 'Mag Mattioni', 'mmattioni1@google.cn', 4072041844);
insert into Owners (Owner_ID, Name, Email, Phone_number) values (13, 'Nari Spinozzi', 'nspinozzi2@delicious.com', 3835035612);
insert into Owners (Owner_ID, Name, Email, Phone_number) values (14, 'Lizbeth Layland', 'lkeetch3@pagesperso-orange.fr', 9431127087);
insert into Owners (Owner_ID, Name, Email, Phone_number) values (15, 'Stanislaus Wanjek', 'swanjek4@google.com.hk', 7189574107);
insert into Owners (Owner_ID, Name, Email, Phone_number) values (16, 'Ronnie McLane', 'rmclane5@studiopress.com', 4544226464);
insert into Owners (Owner_ID, Name, Email, Phone_number) values (17, 'Bartlet Ludmann', 'bludmann6@domainmarket.com', 2406913714);
insert into Owners (Owner_ID, Name, Email, Phone_number) values (18, 'Hertha Tinwell', 'hridout7@ning.com', 4897448597);
insert into Owners (Owner_ID, Name, Email, Phone_number) values (19, 'Nike Grundon', 'ngrundon8@squidoo.com', 3185503402);
insert into Owners (Owner_ID, Name, Email, Phone_number) values (20, 'Aland Hancorn', 'ahancorn9@army.mil', 4829813684);

select * from Owners;

insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (111, 'Thedric De Michele', 'tde0@posterous.com', 8979549307, '7 Shoshone Court');
insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (112, 'Homerus Dommerque', 'hdommerque1@wordpress.org', 4808998379, '60 Pepper Wood Center');
insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (113, 'Gauthier Domerc', 'gdomerc2@wordpress.org', 6685266621, '3964 Jackson Point');
insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (114, 'Viviyan Costi', 'vcosti3@wired.com', 5398721420, '7 Oak Hill');
insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (115, 'Leroi Goody', 'lgoody4@barnesandnoble.com', 5613907068, '0 Katie Plaza');
insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (116, 'Sebastiano Fownes', 'sfownes5@google.de', 5543657099, '57228 Rowland Avenue');
insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (117, 'Matthew Kemble', 'mkemble6@vkontakte.ru', 7348644726, '5359 Sunbrook Place');
insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (118, 'Cahra Fairlaw', 'cfairlaw7@thetimes.co.uk', 7078605269, '0274 Mifflin Parkway');
insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (119, 'Eberto Pagin', 'epagin8@stanford.edu', 6739043973, '9608 Shoshone Court');
insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (120, 'Tammara Weatherhogg', 'tweatherhogg9@merriam.com', '6697219790', '08 Banding Drive');
insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (121, 'Trenton Peacock', 'tpeacocka@parallels.com', 4282951230, '43 Forest Dale Avenue');
insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (122, 'Renata Densie', 'rdensieb@fema.gov', 2374660168, '33 Spohn Plaza');
insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (123, 'Leone Crutcher', 'lcrutcherc@theguardian.com', 6485376842, '106 New Castle Place');
insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (124, 'Anderson Karpmann', 'akarpmannd@linkedin.com', 7763824024, '4 Lukken Center');
insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (125, 'Jessy Boss', 'jbosse@un.org', 3486636640, '37090 Fieldstone Alley');
insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (126, 'Rosalie Govinlock', 'rgovinlockf@fc2.com', 5653292191, '962 Sherman Plaza');
insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (127, 'Irvine Tregust', 'itregustg@huffingtonpost.com', 6368315956, '640 Service Terrace');
insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (128, 'Darius Windless', 'dwindlessh@google.de', 1285462322, '12124 Laurel Avenue');
insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (129, 'Anderson Karpmann', 'hgeratti@ifeng.com', 6284383879, '4784 Oneill Junction');
insert into Clients (Client_ID, Name, Email, Phone_number, Address) values (130, 'Trenton Peacock', 'bkerfootj@rediff.com', 5097629340, '6 Rusk Court');

insert into Properties (Property_ID, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40001, 'Available', '1982', 1543, 4, 'Residential', 18564, 643660);
insert into Properties (Property_ID, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40003, 'Available', '59720', 6541, 3, 'Residential', 8509, 17170000);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40004, 'Available', 781100, 2388, 5, 'Rowland', 14835, 9052832);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40005, 'Available', 781059, 3233, 5, 'Industrial', 7255, 19680402);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40006, 'Available', 781096, 7509, 3, 'Rowland', 5699, null);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40007, 'Available', 781121, 5724, 2, 'Rowland', 3255, null);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40008, 'Available', 781097, 4788, 1, 'Commercial', 6097, 9047803);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40009, 'Available', 781111, 2281, 5, 'Commercial', 11361, null);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40010, 'Available', 781091, 9048, 5, 'Rowland', 9967, 12542605);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40011, 'Available', 781075, 1955, 3, 'Residential', 10118, 830825);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40012, 'Available', 781127, 4701, 5, 'Rowland', 17733, 15237313);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40013, 'Available', 781094, 5776, 5, 'Rowland', 9950, 7678538);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40101, 'Available', 781048, 5110, 4, 'Rowland', 3969, 6529762);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40102, 'Available', 781074, 6015, 4, 'Residential', 9831, 500417);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40103, 'Available', 781047, 4353, 5, 'Industrial', null, 9639321);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40104, 'Available', 781085, 5027, 1, 'Rowland', 10691, 1353185);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40105, 'Available', 781115, 8429, 1, 'Industrial', null, 8980738);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40106, 'Available', 781054, 7602, 4, 'Residential', null, 18676964);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40107, 'Available', 781053, 5529, 4, 'Residential', 17516, 1273324);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40108, 'Available', 781128, 7664, 2, 'Industrial', 13232, 8665083);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (40109, 'Available', 781063, 9034, 3, 'Residential', 17553, 5174762);
insert into Properties (Property_Id, Status, Pin_code, Size_sq_feet, BHK, Property_type, Rent_per_month, Asking_price) values (401010, 'Available', 781018, 7638, 2, 'Commercial', 8388, 4387313);


update Properties set Address = '95 Hayes Drive' where Property_ID = 40001;
update Properties set Address = '9534 Service Terrace' where Property_ID = 40003;
update Properties set Address = '452 La Follette Avenue' where Property_ID = 40004;
update Properties set Address = '77 David Place' where Property_ID = 40005;
update Properties set Address = '60500 Del Mar Point' where Property_ID = 40006;
update Properties set Address = '298 La Follette Lane' where Property_ID = 40007;
update Properties set Address = '103 Grayhawk Court' where Property_ID = 40008;
update Properties set Address = '305 Talmadge Place' where Property_ID = 40009;
update Properties set Address = '0 Moose Circle' where Property_ID = 40010;
update Properties set Address = '18 Bluestem Way' where Property_ID = 40011;
update Properties set Address = '6 Knutson Trail' where Property_ID = 40012;
update Properties set Address = '9 6th Road' where Property_ID = 40013;
update Properties set Address = '72258 Waxwing Drive' where Property_ID = 40101;
update Properties set Address = '429 Artisan Park' where Property_ID = 40102;
update Properties set Address = '19 Saint Paul Crossing' where Property_ID = 40103;
update Properties set Address = '9 Grasskamp Road' where Property_ID = 40104;
update Properties set Address = '127 Eastwood Place' where Property_ID = 40105;
update Properties set Address = '9 Delaware Alley' where Property_ID = 40106;
update Properties set Address = '8 Barnett Pass' where Property_ID = 40107;
update Properties set Address = '6036 Dexter Way' where Property_ID = 40108;
update Properties set Address = '6 Knutson Trail' where Property_ID = 40109;
update Properties set Address = '04028 Springs Trail' where Property_ID = 40110;

INSERT INTO Agent (Agent_ID, Name, Email, Phone_number) VALUES
(1111, 'ABHINAV', 'abhinav@email.com', 1234567890),
(2222, 'Joshi', 'joshi@email.com', 1234567890),
(3333, 'Heenal', 'heenal@email.com', 1234567890),
(4444, 'Shruti', 'shruti@email.com', 1234567890),
(5555, 'reddy', 'bkbreddy26122004@gmail.com', 1234567890);



