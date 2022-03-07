create table BPMAPP_ORGANISATION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CODE varchar(255) not null,
    SHORT_NAME varchar(255) not null,
    FULL_NAME varchar(255) not null,
    FISCAL_ADDRESS varchar(255),
    ADDRESS varchar(255),
    --
    primary key (ID)
);