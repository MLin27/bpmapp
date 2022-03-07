package com.company.bpmapp.web.screens.subdivision;

import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.screen.*;
import com.company.bpmapp.entity.Subdivision;

import javax.inject.Inject;

@UiController("bpmapp_Subdivision.edit")
@UiDescriptor("subdivision-edit.xml")
@EditedEntityContainer("subdivisionDc")
@LoadDataBeforeShow
public class SubdivisionEdit extends StandardEditor<Subdivision> {
    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private PickerField<Subdivision> leadingSubdivisionField;

    @Subscribe("leadingSubdivisionField.lookup")
    public void onLeadingSubdivisionFieldLookup(Action.ActionPerformedEvent event) {
        screenBuilders.lookup(leadingSubdivisionField).withOptions(new MapScreenOptions(ParamsMap.of("sub",getEditedEntity().getId()))).build().show();
    }



}