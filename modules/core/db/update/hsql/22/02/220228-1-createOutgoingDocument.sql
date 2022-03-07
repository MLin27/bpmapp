create table BPMAPP_OUTGOING_DOCUMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DOCUMENT_TYPE_ID varchar(36) not null,
    REGISTRATION_NUMBER varchar(255),
    REGISTRATION_DATE varchar(255),
    ADDRESSEE varchar(255) not null,
    TO_WHOM varchar(255),
    TOPIC varchar(255) not null,
    EXECUTOR_ID varchar(36) not null,
    AUTHOR_ID varchar(36) not null,
    CREATION_DATE date not null,
    EDIT_DATE date,
    --
    primary key (ID)
);