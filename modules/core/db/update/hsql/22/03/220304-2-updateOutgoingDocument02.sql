update BPMAPP_OUTGOING_DOCUMENT set STATE = 'New' where STATE is null ;
alter table BPMAPP_OUTGOING_DOCUMENT alter column STATE set not null ;
