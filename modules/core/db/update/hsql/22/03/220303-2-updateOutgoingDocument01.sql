alter table BPMAPP_OUTGOING_DOCUMENT add constraint FK_BPMAPP_OUTGOING_DOCUMENT_ON_FILE foreign key (FILE_ID) references SYS_FILE(ID);
create index IDX_BPMAPP_OUTGOING_DOCUMENT_ON_FILE on BPMAPP_OUTGOING_DOCUMENT (FILE_ID);
