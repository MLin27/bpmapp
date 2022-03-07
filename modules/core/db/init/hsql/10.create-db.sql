-- begin BPMAPP_SUBDIVISION
create table BPMAPP_SUBDIVISION (
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
    HEAD_OF_DEPARTMENT_ID varchar(36),
    NAME varchar(255) not null,
    LEADING_SUBDIVISION_ID varchar(36),
    --
    primary key (ID)
)^
-- end BPMAPP_SUBDIVISION
-- begin BPMAPP_EMPLOYEE
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
)^
-- end BPMAPP_EMPLOYEE
-- begin BPMAPP_DOCUMENT
create table BPMAPP_DOCUMENT (
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
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end BPMAPP_DOCUMENT
-- begin BPMAPP_ORGANISATION
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
)^
-- end BPMAPP_ORGANISATION
-- begin BPMAPP_JOURNAL
create table BPMAPP_JOURNAL (
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
    NAME varchar(255),
    NUMBER_FORMAT varchar(255),
    DIGIT_AMOUNT integer,
    --
    primary key (ID)
)^
-- end BPMAPP_JOURNAL
-- begin BPMAPP_OUTGOING_DOCUMENT
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
    ORDER_NUM integer,
    JOURNAL_ID varchar(36),
    CONTENT varchar(255),
    CAUSE_ID varchar(36),
    REDIRECTED_TO_CAUSE date,
    SIGNATORY_ID varchar(36),
    COORDINATOR_ID varchar(36),
    TASK_START_DATE date,
    TASK_COMPLETE_DATE date,
    RESULT_ varchar(255),
    COMMENT_ varchar(255),
    STATE varchar(50),
    REGISTRATION_NUMBER varchar(255),
    REGISTRATION_DATE date,
    ADDRESSEE varchar(255) not null,
    TO_WHOM varchar(255),
    TOPIC varchar(255) not null,
    EXECUTOR_ID varchar(36) not null,
    AUTHOR_ID varchar(36) not null,
    NOTE longvarchar,
    NAME longvarchar,
    CREATION_DATE date not null,
    EDIT_DATE date,
    --
    primary key (ID)
)^
-- end BPMAPP_OUTGOING_DOCUMENT
-- begin BPMAPP_NOMENCLATURE
create table BPMAPP_NOMENCLATURE (
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
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end BPMAPP_NOMENCLATURE
-- begin BPMAPP_OUTGOING_DOCUMENT_FILE_DESCRIPTOR_LINK
create table BPMAPP_OUTGOING_DOCUMENT_FILE_DESCRIPTOR_LINK (
    OUTGOING_DOCUMENT_ID varchar(36) not null,
    FILE_DESCRIPTOR_ID varchar(36) not null,
    primary key (OUTGOING_DOCUMENT_ID, FILE_DESCRIPTOR_ID)
)^
-- end BPMAPP_OUTGOING_DOCUMENT_FILE_DESCRIPTOR_LINK
