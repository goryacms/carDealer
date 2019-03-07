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
    ISSUE_YEAR integer,
    CAR_COST decimal(19, 2),
    --
    primary key (ID)
);
