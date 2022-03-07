package com.company.bpmapp.web.screens.subdivision;

import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.bpmapp.entity.Subdivision;

import javax.inject.Inject;
import java.util.Map;

@UiController("bpmapp_Subdivision.browse")
@UiDescriptor("subdivision-browse.xml")
@LookupComponent("subdivisionsTable")
@LoadDataBeforeShow
public class SubdivisionBrowse extends StandardLookup<Subdivision> {
    @Inject
    private CollectionLoader<Subdivision> subdivisionsDl;
    @Inject
    private CollectionContainer<Subdivision> subdivisionsDc;

    @Subscribe
    public void onInit(InitEvent event) {
        if(event.getOptions() instanceof MapScreenOptions) {
            Map<String, Object> params = ((MapScreenOptions) event.getOptions()).getParams();
            if (params.get("sub") != null){
                subdivisionsDl.setQuery(String.format("select e from bpmapp_Subdivision e where e.id <>'%s'", params.get("sub").toString()));
            }


        }

    }

    @Install(to = "subdivisionsTable.create", subject = "initializer")
    private void subdivisionsTableCreateInitializer(Subdivision subdivision) {
        subdivision.setCode("000" + subdivisionsDc.getItems().size());
    }



}