alter table BPMAPP_OUTGOING_DOCUMENT add constraint FK_BPMAPP_OUTGOING_DOCUMENT_ON_CAUSE foreign key (CAUSE_ID) references BPMAPP_NOMENCLATURE(ID);
create index IDX_BPMAPP_OUTGOING_DOCUMENT_ON_CAUSE on BPMAPP_OUTGOING_DOCUMENT (CAUSE_ID);
