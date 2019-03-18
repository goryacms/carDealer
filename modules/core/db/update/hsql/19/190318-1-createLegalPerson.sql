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
);
