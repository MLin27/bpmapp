create table BPMAPP_EMPLOYEE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    OFF_ID varchar(255) not null,
    USER_ID varchar(36),
    LAST_NAME varchar(255) not null,
    FIRST_NAME varchar(255) not null,
    MIDDLE_NAME varchar(255),
    SUBDIVISION_ID varchar(36) not null,
    EMAIL varchar(255),
    PHONE_NUMBER varchar(255),
    PHOTO_ID varchar(36),
    --
    primary key (ID)
);