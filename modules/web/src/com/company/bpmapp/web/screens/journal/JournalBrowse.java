package com.company.bpmapp.web.screens.journal;

import com.haulmont.cuba.gui.components.Window;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.bpmapp.entity.Journal;

import javax.inject.Inject;

@UiController("bpmapp_Journal.browse")
@UiDescriptor("journal-browse.xml")
@LookupComponent("journalsTable")
@LoadDataBeforeShow
public class JournalBrowse extends StandardLookup<Journal> {

    @Inject
    private CollectionContainer<Journal> journalsDc;

    @Install(to = "journalsTable.create", subject = "initializer")
    private void journalsTableCreateInitializer(Journal journal) {
        journal.setCode("Ж00000" + journalsDc.getItems().size());

    }


}