package com.company.bpmapp.web.screens.organisation;

import com.haulmont.cuba.gui.screen.*;
import com.company.bpmapp.entity.Organisation;

@UiController("bpmapp_Organisation.edit")
@UiDescriptor("organisation-edit.xml")
@EditedEntityContainer("organisationDc")
@LoadDataBeforeShow
public class OrganisationEdit extends StandardEditor<Organisation> {
}