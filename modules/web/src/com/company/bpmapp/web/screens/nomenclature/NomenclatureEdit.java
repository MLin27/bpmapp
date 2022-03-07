package com.company.bpmapp.web.screens.nomenclature;

import com.haulmont.cuba.gui.screen.*;
import com.company.bpmapp.entity.Nomenclature;

@UiController("bpmapp_Nomenclature.edit")
@UiDescriptor("nomenclature-edit.xml")
@EditedEntityContainer("nomenclatureDc")
@LoadDataBeforeShow
public class NomenclatureEdit extends StandardEditor<Nomenclature> {
}