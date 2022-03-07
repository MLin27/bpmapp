package com.company.bpmapp.web.screens.document;

import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.bpmapp.entity.Document;

import javax.inject.Inject;

@UiController("bpmapp_Document.edit")
@UiDescriptor("document-edit.xml")
@EditedEntityContainer("documentDc")
@LoadDataBeforeShow
public class DocumentEdit extends StandardEditor<Document> {

}