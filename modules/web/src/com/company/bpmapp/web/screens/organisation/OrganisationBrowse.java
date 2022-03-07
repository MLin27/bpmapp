package com.company.bpmapp.web.screens.organisation;

import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.bpmapp.entity.Organisation;

import javax.inject.Inject;

@UiController("bpmapp_Organisation.browse")
@UiDescriptor("organisation-browse.xml")
@LookupComponent("organisationsTable")
@LoadDataBeforeShow
public class OrganisationBrowse extends StandardLookup<Organisation> {

    @Inject
    private CollectionContainer<Organisation> organisationsDc;

    @Install(to = "organisationsTable.create", subject = "initializer")
    private void organisationsTableCreateInitializer(Organisation organisation) {
        organisation.setCode("ОРГ00000" + organisationsDc.getItems().size());
    }
    
}