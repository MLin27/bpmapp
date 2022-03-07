package com.company.bpmapp.web.screens.document;

import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.bpmapp.entity.Document;

import javax.inject.Inject;

@UiController("bpmapp_Document.browse")
@UiDescriptor("document-browse.xml")
@LookupComponent("documentsTable")
@LoadDataBeforeShow
public class DocumentBrowse extends StandardLookup<Document> {
    @Inject
    private CollectionContainer<Document> documentsDc;

    @Install(to = "documentsTable.create", subject = "initializer")
    private void documentsTableCreateInitializer(Document document) {
        document.setCode("ВД00000" + documentsDc.getItems().size());

    }

}