create table BPMAPP_OUTGOING_DOCUMENT_FILE_DESCRIPTOR_LINK (
    OUTGOING_DOCUMENT_ID varchar(36) not null,
    FILE_DESCRIPTOR_ID varchar(36) not null,
    primary key (OUTGOING_DOCUMENT_ID, FILE_DESCRIPTOR_ID)
);
