INSERT INTO Role VALUES (1, 'ADMIN');
INSERT INTO Role VALUES (2, 'BUYER');
INSERT INTO Role VALUES (3, 'SELLER');

-- password: 12345
-- $2a$10$L0.rBaVpWXnEUzMAgOHynuE/8pmxVA0zWsd3eL6xI.UR69G.nR5P6

INSERT INTO User (user_id, active, password, username)
VALUES (30, 1,'$2a$10$L0.rBaVpWXnEUzMAgOHynuE/8pmxVA0zWsd3eL6xI.UR69G.nR5P6', 'tsegidey@gmail.com');
INSERT INTO user_role (user_id, role_id) VALUES(30,2);
INSERT INTO buyer ( email, first_name, last_name, user_id, id)
VALUES('tsegidey@gmail.com','Tsegazeab','Gudey',30,30);


INSERT INTO User (user_id, active, password, username)VALUES
(20, 1,'$2a$10$L0.rBaVpWXnEUzMAgOHynuE/8pmxVA0zWsd3eL6xI.UR69G.nR5P6', 'seller@gmail.com');
INSERT INTO user_role (user_id, role_id) VALUES(20,3);
INSERT INTO  Seller (SERLLER_ID,EMAIL,FULL_NAME,AREA_CODE,PHONE_NUMBER,USER_ID)
VALUES(20,'seller@gmail.com','Hailu Hagos','112','111',20);


INSERT INTO User (user_id, active, password, username)
VALUES (50, 1,'$2a$10$L0.rBaVpWXnEUzMAgOHynuE/8pmxVA0zWsd3eL6xI.UR69G.nR5P6', 'lisa@gmail.com');
INSERT INTO user_role (user_id, role_id) VALUES(50,2);
INSERT INTO  Seller (SERLLER_ID,EMAIL,FULL_NAME,AREA_CODE,PHONE_NUMBER,USER_ID)
VALUES(50,'lisa@gmail.com','Elsabeth ','112','111',50);


INSERT INTO User (user_id, active, password, username)VALUES
(40, 1,'$2a$10$L0.rBaVpWXnEUzMAgOHynuE/8pmxVA0zWsd3eL6xI.UR69G.nR5P6', 'addis@gmail.com');
INSERT INTO user_role (user_id, role_id) VALUES(40,3);
INSERT INTO  Seller (SERLLER_ID,EMAIL,FULL_NAME,AREA_CODE,PHONE_NUMBER,USER_ID)
VALUES(40,'addis@gmail.com','Addis','112','111',40);



INSERT INTO User (user_id, active, password, username)VALUES
(60, 1,'$2a$10$L0.rBaVpWXnEUzMAgOHynuE/8pmxVA0zWsd3eL6xI.UR69G.nR5P6', 'seller2@gmail.com');
INSERT INTO user_role (user_id, role_id) VALUES(60,3);
INSERT INTO  Seller (SERLLER_ID,EMAIL,FULL_NAME,AREA_CODE,PHONE_NUMBER,USER_ID)
VALUES(60,'seller2@gmail.com','Seller N Name','112','111',60);


--$2y$12$rW7MkmPuiF101uqJFlXAT.DpJFA4G0qzxSrmUp9Wl0wblSd0SZx0G

INSERT INTO User (user_id, active, password, username)
VALUES (70, 1,'$2a$10$L0.rBaVpWXnEUzMAgOHynuE/8pmxVA0zWsd3eL6xI.UR69G.nR5P6', 'admin@gmail.com');
INSERT INTO user_role (user_id, role_id) VALUES(70, 1);
INSERT INTO Admin (email, first_name, last_name, user_id, id)
VALUES('admin@gmail.com','admin first name','admin last name',70,70);



INSERT INTO Category VALUES (1, 'Phone');
INSERT INTO Category VALUES (2, 'Computer');
INSERT INTO Category VALUES (3, 'Food');


         INSERT INTO Category VALUES (4, 'Clothes');
          INSERT INTO Category VALUES (5, 'Books');
         INSERT INTO Category VALUES (6, 'Musics');
          INSERT INTO Category VALUES (7, 'Cosmetics');
           INSERT INTO Category VALUES (8, 'shoes');

INSERT INTO Product VALUES ( 20,2 , 'Phone the lightest 7 inch tablet with a quad-core S4',true, 713,'P123','iPhone ','iPhone 7s',1,20);
INSERT INTO Product VALUES ( 21,3 , 'Google Nexus 7 is the lightest 7 inch tablet with a',false, 1364.7,'pC1235','Dell Inspirit','Dell Inspiron',2,20);


INSERT INTO Product VALUES ( 22,4 , 'Phone the lightest 7 inch tablet with a quad-core S',true, 1986.6,'P1234','Samsung Inspiron','Samsung Inspiron ',1,20);
INSERT INTO Product VALUES ( 23,3 , 'Google Nexus 7 is the lightest 7 inch tablet with a',true, 1254.5,'C123','MAC Inspirit','MAC Inspiron',2,20);

INSERT INTO Product VALUES ( 24,5 , 'Phone the lightest 7 inch tablet with a quad-core S4',true, 1244.5,'P12345','iPhone 6s','Phone SAm',1,20);
INSERT INTO Product VALUES ( 26,3 , 'Google Nexus 7 is the lightest 7 inch tablet with',true, 562.5,'C1234','Dell Inspirit','Dell Inspiron',2,20);

INSERT INTO Product VALUES ( 27,5 , 'Foods against each other by labelling them',true, 22.5,'F1234','Apple ','Apple Inspiron',3,20);
INSERT INTO Product VALUES ( 28,3 , 'Foods against each other by labelling them',true, 12.5,'F123','Banana','Banana Inspiron',3,20);



--INSERT INTO Product VALUES ( 29,5 , 'American Dirt (Oprahs Book Club): A Novel',true, 22.5,'B1234','American Dirt Book ','American Dirt Book ',5,20);

