-- begin CARDEALER_COUNTRY
create table CARDEALER_COUNTRY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(100),
    CODE varchar(50),
    --
    primary key (ID)
)^
-- end CARDEALER_COUNTRY
-- begin CARDEALER_AUTOMAKER
create table CARDEALER_AUTOMAKER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CODE varchar(50) not null,
    COUNTRY_ID varchar(36),
    --
    primary key (ID)
)^
-- end CARDEALER_AUTOMAKER
-- begin CARDEALER_COLOR
create table CARDEALER_COLOR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(15) not null,
    CODE varchar(10) not null,
    --
    primary key (ID)
)^
-- end CARDEALER_COLOR
-- begin CARDEALER_EQUIPMENT
create table CARDEALER_EQUIPMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(50),
    COST decimal(19, 2),
    CAR_TYPE integer,
    NOTE varchar(255),
    CAR_MODEL_ID varchar(36),
    --
    primary key (ID)
)^
-- end CARDEALER_EQUIPMENT
-- begin CARDEALER_CAR_MODEL
create table CARDEALER_CAR_MODEL (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(50),
    AUTOMAKER_ID varchar(36),
    --
    primary key (ID)
)^
-- end CARDEALER_CAR_MODEL
-- begin CARDEALER_CAR
create table CARDEALER_CAR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    AUTOMAKER_ID varchar(36),
    CAR_MODEL_ID varchar(36),
    EQUIPMENT_ID varchar(36),
    NAME varchar(255),
    ISSUE_YEAR varchar(20),
    CAR_COST decimal(19, 2),
    --
    primary key (ID)
)^
-- end CARDEALER_CAR

-- begin CARDEALER_CAR_PURCHASE_REQUEST
create table CARDEALER_CAR_PURCHASE_REQUEST (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CAR_ID varchar(36),
    CAR_PAID boolean,
    INDIVIDUAL_PERSON_ID varchar(36),
    LEGAL_PERSON_ID varchar(36),
    AMOUNT decimal(19, 2),
    TAX decimal(19, 2),
    MANAGER_ID varchar(36),
    STATE varchar(255),
    --
    primary key (ID)
)^
-- end CARDEALER_CAR_PURCHASE_REQUEST
-- begin SEC_USER
alter table SEC_USER add column COUNTRY_ID varchar(36) ^
alter table SEC_USER add column DTYPE varchar(100) ^
update SEC_USER set DTYPE = 'cardealer$ExtUser' where DTYPE is null ^
-- end SEC_USER
-- begin CARDEALER_PROC_ATTACHMENT
create table CARDEALER_PROC_ATTACHMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CAR_PURCHASE_REQUEST_ID varchar(36),
    --
    primary key (ID)
)^
-- end CARDEALER_PROC_ATTACHMENT
-- begin CARDEALER_LEGAL_PERSON
create table CARDEALER_LEGAL_PERSON (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    PHONE varchar(20),
    --
    NAME varchar(75),
    INN_AND_ADDRESS longvarchar,
    --
    primary key (ID)
)^
-- end CARDEALER_LEGAL_PERSON
-- begin CARDEALER_INDIVIDUAL_PERSON
create table CARDEALER_INDIVIDUAL_PERSON (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    PHONE varchar(20),
    --
    NAME_AND_LAST_NAME varchar(255),
    --
    primary key (ID)
)^
-- end CARDEALER_INDIVIDUAL_PERSON
