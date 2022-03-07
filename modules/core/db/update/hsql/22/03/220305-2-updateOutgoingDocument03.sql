alter table BPMAPP_OUTGOING_DOCUMENT add column CAUSE_ID varchar(36) ;
alter table BPMAPP_OUTGOING_DOCUMENT add column REDIRECTED_TO_CAUSE date ;
alter table BPMAPP_OUTGOING_DOCUMENT add column JOURNAL_ID varchar(36) ;
alter table BPMAPP_OUTGOING_DOCUMENT add column CONTENT varchar(255) ;
