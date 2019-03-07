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
);
