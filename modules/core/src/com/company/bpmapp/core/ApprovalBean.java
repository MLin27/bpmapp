package com.company.bpmapp.core;

import com.company.bpmapp.entity.DocumentState;
import com.company.bpmapp.entity.OutgoingDocument;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.UUID;

@Component(ApprovalBean.NAME)
public class ApprovalBean {
    public static final String NAME = "bpmapp_ApprovalBean";

    @Inject
    private Persistence persistence;

    public void updateState(UUID entityId, DocumentState state) {
        try (Transaction tx = persistence.getTransaction()) {
            OutgoingDocument outDoc = persistence.getEntityManager().find(OutgoingDocument.class, entityId);
            if (outDoc != null) {
                outDoc.setState(state);
            }
            tx.commit();
        }
    }
}