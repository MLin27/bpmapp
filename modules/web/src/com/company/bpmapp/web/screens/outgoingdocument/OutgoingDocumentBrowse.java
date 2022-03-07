package com.company.bpmapp.web.screens.outgoingdocument;

import com.company.bpmapp.entity.DocumentState;
import com.company.bpmapp.entity.Employee;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.bpmapp.entity.OutgoingDocument;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.reports.gui.actions.EditorPrintFormAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

@UiController("bpmapp_OutgoingDocument.browse")
@UiDescriptor("outgoing-document-browse.xml")
@LookupComponent("outgoingDocumentsTable")

@LoadDataBeforeShow
public class OutgoingDocumentBrowse extends StandardLookup<OutgoingDocument> {

    // create logger
    private static Logger log = LoggerFactory.getLogger(OutgoingDocumentBrowse.class);
    @Inject
    protected UserSessionSource userSessionSource;
    @Inject
    private DataManager dataManager;
    @Inject
    private Button actionProcBtn;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private CollectionContainer<OutgoingDocument> outgoingDocumentsDc;

    @Install(to = "outgoingDocumentsTable.create", subject = "initializer")
    private void outgoingDocumentsTableCreateInitializer(OutgoingDocument outgoingDocument) {

        User user = userSessionSource.getUserSession().getUser();
        List<Employee> listView = dataManager.load(Employee.class).view("employee-view-user").list();

        for(int i=0; i<listView.size(); i++){
            Employee e = listView.get(i);

            if (e.getUser().getId().toString().equals(user.getId().toString())){
                outgoingDocument.setExecutor(e);
                log.info("found a matching Employee");
            }
            else {
                log.debug("no match found for Employee in initializer");
            }
        }

        outgoingDocument.setAuthor(user);

        if (outgoingDocument.getCreationDate() == null) {
            outgoingDocument.setCreationDate(LocalDate.now());
            log.info("set creation date as Today");
        }
        outgoingDocument.setEditDate(LocalDate.now());
        outgoingDocument.setRegistrationDate(LocalDate.now());
        outgoingDocument.setState(DocumentState.NEW);
        outgoingDocument.setOrderNum(outgoingDocumentsDc.getItems().size());
    }




    }
