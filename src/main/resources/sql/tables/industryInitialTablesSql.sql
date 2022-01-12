CREATE TABLE IF NOT EXISTS TBL_CATEGORY (ID BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL, NAME VARCHAR(255), DESCRIPTION VARCHAR(255), IMAGE VARCHAR(255), CONSTRAINT SYS_PK_10095 PRIMARY KEY (ID))
CREATE UNIQUE INDEX IF NOT EXISTS SYS_IDX_SYS_PK_10095_10104 ON TBL_CATEGORY (NAME);

CREATE TABLE IF NOT EXISTS TBL_ITEM (ID BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL, NAME VARCHAR(255), DESCRIPTION VARCHAR(255), IMAGE VARCHAR(255), IN_STOCK INTEGER, CATEGORY_ID BIGINT, REGION VARCHAR(255), LAST_ACCESSED_DATE TIMESTAMP, CONSTRAINT SYS_PK_10097 PRIMARY KEY (ID), CONSTRAINT FKN27UG21LW38SS31EXIAHHQH8B FOREIGN KEY (CATEGORY_ID) REFERENCES TBL_CATEGORY(ID))
CREATE INDEX IF NOT EXISTS SYS_IDX_FKN27UG21LW38SS31EXIAHHQH8B_10100 ON TBL_ITEM (CATEGORY_ID)

CREATE TABLE IF NOT EXISTS TBL_CART (ID BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL, USER_ID BIGINT, ITEM_ID BIGINT, NAME VARCHAR(255), DESCRIPTION VARCHAR(255), IMAGE VARCHAR(255), QUANTITY INTEGER, CONSTRAINT SYS_PK_10131 PRIMARY KEY (ID))

CREATE TABLE IF NOT EXISTS TBL_LOCATION (ID BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL, REGION VARCHAR(255), LOCATION_INFO VARCHAR(255), LOCATION_IMAGE VARCHAR(255), CONSTRAINT SYS_PK_10141 PRIMARY KEY (ID))

CREATE TABLE IF NOT EXISTS TBL_ORDER (ID BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL, USER_ID BIGINT, STATUS VARCHAR(255), REVIEWED_BY_PRCH TINYINT, REVIEWED_BY_APV TINYINT, ORDER_NUMBER VARCHAR(255), REGION VARCHAR(255), LOCATION VARCHAR(255), ORDER_IMAGE VARCHAR(255), RECEIVER_ID VARCHAR(225), EVENT_ID VARCHAR(225), EVENT_NUMBER VARCHAR(225), SUBMISSION_DATE TIMESTAMP, APPROVER_REPLY_DATE TIMESTAMP, COMMENTS VARCHAR(225), CONSTRAINT SYS_PK_10142 PRIMARY KEY (ID))
CREATE UNIQUE INDEX IF NOT EXISTS TBL_ORDER_REQUISITION_NUMBER_IDX ON TBL_ORDER (ORDER_NUMBER);

CREATE TABLE IF NOT EXISTS TBL_ORDER_ITEM (ID BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL, NAME VARCHAR(255), DESCRIPTION VARCHAR(255), IMAGE VARCHAR(255), ORDER_ID BIGINT, ITEM_ID BIGINT, QUANTITY INTEGER, CONSTRAINT TBL_ORDER_ITEM_PK PRIMARY KEY (ID), CONSTRAINT TBL_ORDER_ITEM_FK FOREIGN KEY (ORDER_ID) REFERENCES TBL_ORDER(ID))
CREATE INDEX IF NOT EXISTS SYS_IDX_TBL_ORDER_ITEM_FK_10203 ON TBL_ORDER_ITEM (ORDER_ID);

CREATE TABLE IF NOT EXISTS TBL_LABEL (ID BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL, NAME VARCHAR(255), VALUE VARCHAR(255), LANGUAGE_TYPE VARCHAR(255), CONSTRAINT TBL_LABEL_PK PRIMARY KEY (ID))
CREATE INDEX IF NOT EXISTS SYS_IDX_TBL_LABEL_FK_10303 ON TBL_LABEL (LANGUAGE_TYPE);