alter table BPMAPP_OUTGOING_DOCUMENT add column RESULT_ varchar(255) ;
alter table BPMAPP_OUTGOING_DOCUMENT add column TASK_COMPLETE_DATE date ;
alter table BPMAPP_OUTGOING_DOCUMENT add column COORDINATOR_ID varchar(36) ;
alter table BPMAPP_OUTGOING_DOCUMENT add column STATE varchar(50) ;
alter table BPMAPP_OUTGOING_DOCUMENT add column TASK_START_DATE date ;
alter table BPMAPP_OUTGOING_DOCUMENT add column COMMENT_ varchar(255) ;
