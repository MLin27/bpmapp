package com.company.bpmapp.web.screens.nomenclature;

import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.bpmapp.entity.Nomenclature;

import javax.inject.Inject;

@UiController("bpmapp_Nomenclature.browse")
@UiDescriptor("nomenclature-browse.xml")
@LookupComponent("nomenclaturesTable")
@LoadDataBeforeShow
public class NomenclatureBrowse extends StandardLookup<Nomenclature> {

    @Inject
    private CollectionContainer<Nomenclature> nomenclaturesDc;

    @Install(to = "nomenclaturesTable.create", subject = "initializer")
    private void nomenclaturesTableCreateInitializer(Nomenclature nomenclature) {
        nomenclature.setCode("НД00000" + nomenclaturesDc.getItems().size());

    }

}