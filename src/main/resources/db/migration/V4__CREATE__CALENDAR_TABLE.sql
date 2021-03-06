
CREATE TABLE TWSS_CALENDAR(
    ID NUMBER NOT NULL,
    ID_CLOTHE NUMBER NOT NULL,
    UUID_CLOTHE VARCHAR2(250 BYTE) NOT NULL,
    USERNAME VARCHAR2(250 BYTE) NOT NULL,
    DAY DATE NOT NULL,
    CREATED TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP NOT NULL,
    MODIFIED TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT TWSS_CALENDAR_PK PRIMARY KEY (ID) ENABLE,
    CONSTRAINT TWSS_CALENDAR_CL_FK FOREIGN KEY (ID_CLOTHE) REFERENCES TWSS_CLOTHES(ID)
);


CREATE SEQUENCE TWSS_CALENDAR_SEQ;
 
CREATE TRIGGER TWSS_CALENDAR_TRG
BEFORE INSERT ON TWSS_CALENDAR
FOR EACH ROW
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT TWSS_CALENDAR_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/