Insert into TWSS_BRANDS (ID,NAME) values (1,'AMERICACINO');
Insert into TWSS_BRANDS (ID,NAME) values (2,'LEVIS');
Insert into TWSS_BRANDS (ID,NAME) values (3,'BIG JOHN');
Insert into TWSS_BRANDS (ID,NAME) values (4,'RIFLE');
Insert into TWSS_BRANDS (ID,NAME) values (5,'NIKE');

Insert into TWSS_CLOTHING_CATEGORIES (ID,NAME) values (1,'INFORMAL');
Insert into TWSS_CLOTHING_CATEGORIES (ID,NAME) values (2,'FORMAL');
Insert into TWSS_CLOTHING_CATEGORIES (ID,NAME) values (3,'TRABAJO');
Insert into TWSS_CLOTHING_CATEGORIES (ID,NAME) values (4,'DEPORTIVA');

Insert into TWSS_CLOTHING_TYPES (ID,NAME) values (1,'BOXER');
Insert into TWSS_CLOTHING_TYPES (ID,NAME) values (2,'CAMISETA');
Insert into TWSS_CLOTHING_TYPES (ID,NAME) values (3,'CAMISA');
Insert into TWSS_CLOTHING_TYPES (ID,NAME) values (4,'MEDIAS');
Insert into TWSS_CLOTHING_TYPES (ID,NAME) values (5,'PANTALONES');
Insert into TWSS_CLOTHING_TYPES (ID,NAME) values (6,'ZAPATOS');
Insert into TWSS_CLOTHING_TYPES (ID,NAME) values (7,'TENIS');

Insert into TWSS_CLOTHES (UUID,USERNAME,NAME,DESCRIPTION,TYPE,CATEGORY,PURCHASE_DATE,HOW_LIKE,BRAND,STATE,COLOR_CODE,COLOR_NAME) values ('3cd24e84-92a6-11e8-9eb6-529269fb1459','julian','CAMISA AZUL OSCURA RIFLE','CAMISA AZUL OSCURA RIFLE COMPRADA EN MARINILLA','CAMISA','INFORMAL',to_date('04-JUL-17','DD-MON-RR'),8,'RIFLE',1,'#081c3d','AZUL');