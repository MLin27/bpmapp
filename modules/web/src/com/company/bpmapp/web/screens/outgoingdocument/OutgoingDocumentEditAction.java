package com.company.bpmapp.web.screens.outgoingdocument;

import com.haulmont.cuba.gui.screen.*;
import com.company.bpmapp.entity.OutgoingDocument;
import com.haulmont.bpm.entity.ProcAttachment;
import com.haulmont.bpm.gui.procactionsfragment.ProcActionsFragment;
import com.haulmont.cuba.gui.app.core.file.FileDownloadHelper;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.model.InstanceLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;


@UiController("bpmapp_OutgoingDocument.editAction")
@UiDescriptor("outgoing-document-editAction.xml")
@EditedEntityContainer("outgoingDocumentDc")
@LoadDataBeforeShow
public class OutgoingDocumentEditAction extends StandardEditor<OutgoingDocument> {
    private static final String PROCESS_CODE = "approvalOfTheOutgoingDocument";

    @Inject
    private CollectionLoader<ProcAttachment> procAttachmentsDl;

    @Inject
    private InstanceContainer<OutgoingDocument> outgoingDocumentDc;

    @Inject
    protected ProcActionsFragment procActionsFragment;

    @Inject
    private Table<ProcAttachment> attachmentsTable;

    @Inject
    private InstanceLoader<OutgoingDocument> outgoingDocumentDl;

    @Subscribe
    private void onBeforeShow(BeforeShowEvent event) {
        outgoingDocumentDl.load();
        procAttachmentsDl.setParameter("entityId",outgoingDocumentDc.getItem().getId());
        procAttachmentsDl.load();
        procActionsFragment.initializer()
                .standard()
                .init(PROCESS_CODE, getEditedEntity());

        FileDownloadHelper.initGeneratedColumn(attachmentsTable, "file");
    }
}