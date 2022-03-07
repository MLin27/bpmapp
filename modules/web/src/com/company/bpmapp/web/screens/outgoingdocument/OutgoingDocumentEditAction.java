package com.company.bpmapp.web.screens.outgoingdocument;

import com.haulmont.bpm.entity.ProcActor;
import com.haulmont.bpm.entity.ProcInstance;
import com.haulmont.bpm.entity.ProcRole;
import com.haulmont.bpm.gui.action.StartProcessAction;
import com.haulmont.bpm.service.BpmEntitiesService;
import com.haulmont.bpm.service.ProcessRuntimeService;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.View;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupBoxLayout;
import com.haulmont.cuba.gui.components.HBoxLayout;
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
import com.haulmont.cuba.gui.util.OperationResult;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.security.global.UserSession;
import sun.misc.resources.Messages;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@UiController("bpmapp_OutgoingDocument.editAction")
@UiDescriptor("outgoing-document-editAction.xml")
@EditedEntityContainer("outgoingDocumentDc")
@LoadDataBeforeShow
public class OutgoingDocumentEditAction extends StandardEditor<OutgoingDocument> {
    private static final String PROCESS_CODE = "approvalOfTheOutgoingDocument";
    
    @Inject
    private InstanceContainer<OutgoingDocument> outgoingDocumentDc;

    @Inject
    protected ProcActionsFragment procActionsFragment;

    @Inject
    private InstanceLoader<OutgoingDocument> outgoingDocumentDl;

    @Inject
    private BpmEntitiesService bpmEntitiesService;

    @Inject
    private Metadata metadata;


    @Subscribe
    private void onBeforeShow(BeforeShowEvent event) {
        initProcActionsFragment();
        changeStartProcessBtnCaption();
    }

    private void initProcActionsFragment() {
        procActionsFragment.initializer()
                .standard()
                .setBeforeStartProcessPredicate(() -> {
                    if (commitChanges().getStatus() == OperationResult.Status.SUCCESS) {
                        ProcInstance procInstance = procActionsFragment.getProcInstance();
                        ProcActor initiatorProcActor = createProcActor("initiator", procInstance, getEditedEntity().getExecutor().getUser());
                        ProcActor headOfDepProcActor = createProcActor("headOfDep", procInstance, getEditedEntity().getExecutor().getSubdivision().getHeadOfDepartment().getUser());
                        ProcActor signatoryProcActor = createProcActor("signatory", procInstance, getEditedEntity().getSignatory().getUser());
                        Set<ProcActor> procActors = new HashSet<>();
                        procActors.add(initiatorProcActor);
                        procActors.add(headOfDepProcActor);
                        procActors.add(signatoryProcActor);
                        procInstance.setProcActors(procActors);
                        return true;
                    }
                    return false;
                })
                .setStartProcessActionProcessVariablesSupplier(() -> {
                    Map<String, Object> processVariables = new HashMap<>();
                    processVariables.put("state", getEditedEntity().getState());
                    return processVariables;
                })
                .setAfterStartProcessListener(() -> {
                    initProcActionsFragment();
                    outgoingDocumentDl.setEntityId(getEditedEntity().getId());
                    outgoingDocumentDl.load();
                })
                .setAfterCompleteTaskListener(() -> {

                    initProcActionsFragment();
                    outgoingDocumentDl.setEntityId(getEditedEntity().getId());
                    outgoingDocumentDl.load();
                })
                .init(PROCESS_CODE, getEditedEntity());
    }

    private ProcActor createProcActor(String procRoleCode, ProcInstance procInstance, User user) {
        ProcActor initiatorProcActor = metadata.create(ProcActor.class);
        initiatorProcActor.setUser(user);
        ProcRole initiatorProcRole = bpmEntitiesService.findProcRole(PROCESS_CODE, procRoleCode, View.MINIMAL);
        initiatorProcActor.setProcRole(initiatorProcRole);
        initiatorProcActor.setProcInstance(procInstance);
        return initiatorProcActor;
    }

    private void changeStartProcessBtnCaption() {
        StartProcessAction startProcessAction = procActionsFragment.getStartProcessAction();
        if (startProcessAction != null) {
            startProcessAction.setCaption("Start process");
        }
    }
}