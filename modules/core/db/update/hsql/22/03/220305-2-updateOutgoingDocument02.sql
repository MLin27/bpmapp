alter table BPMAPP_OUTGOING_DOCUMENT alter column FILE_ID rename to FILE_ID__U75079 ^
alter table BPMAPP_OUTGOING_DOCUMENT drop constraint FK_BPMAPP_OUTGOING_DOCUMENT_ON_FILE ;
drop index IDX_BPMAPP_OUTGOING_DOCUMENT_ON_FILE ;
