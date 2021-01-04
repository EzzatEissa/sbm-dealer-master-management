alter session set "_ORACLE_SCRIPT"=true;
CREATE USER dealerdb IDENTIFIED BY root;
GRANT CONNECT TO dealerdb;
GRANT CREATE SESSION, GRANT ANY PRIVILEGE TO dealerdb;
GRANT UNLIMITED TABLESPACE TO dealerdb;
GRANT CREATE TABLE TO dealerdb;
GRANT CREATE SEQUENCE to dealerdb;
GRANT CREATE TRIGGER TO dealerdb;

  CREATE TABLE "DEALERDB"."DEALER" 
   (	"ID" NUMBER(19,0) NOT NULL ENABLE, 
	"DEALER_CODE" VARCHAR2(255 CHAR), 
	"DEALER_NAME" VARCHAR2(255 CHAR), 
	"LANGUAGE" VARCHAR2(255 CHAR), 
	"PREFERRED_DEALER" VARCHAR2(255 CHAR), 
	"SALES_PARTNER" VARCHAR2(255 CHAR), 
	"USED_CATEGORY" NUMBER(1,0) NOT NULL ENABLE, 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

CREATE "DEALERDB"."SEQUENCE DEALER_SEQ"
MINVALUE 1
MAXVALUE 9999999999999999999999999999
INCREMENT BY 1
START WITH 1
CACHE 20
NOORDER  
NOCYCLE  
NOKEEP  
NOSCALE  
GLOBAL ;
 
CREATE OR REPLACE TRIGGER "DEALERDB"."DEALER_AUT_INC" 
BEFORE INSERT ON "DEALERDB"."DEALER"
FOR EACH ROW
BEGIN
  SELECT "DEALERDB"."DEALER_SEQ".NEXTVAL
  INTO   : new.id
  FROM   dual;
END;