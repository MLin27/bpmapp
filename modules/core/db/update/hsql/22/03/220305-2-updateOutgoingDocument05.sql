alter table BPMAPP_OUTGOING_DOCUMENT add constraint FK_BPMAPP_OUTGOING_DOCUMENT_ON_JOURNAL foreign key (JOURNAL_ID) references BPMAPP_JOURNAL(ID);
create index IDX_BPMAPP_OUTGOING_DOCUMENT_ON_JOURNAL on BPMAPP_OUTGOING_DOCUMENT (JOURNAL_ID);