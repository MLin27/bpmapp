package com.company.bpmapp.listeners;

import com.company.bpmapp.entity.Subdivision;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.UUID;

@Component("bpmapp_SubdivisionChangedListener")
public class SubdivisionChangedListener {

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void beforeCommit(EntityChangedEvent<Subdivision, UUID> event) {

    }
}