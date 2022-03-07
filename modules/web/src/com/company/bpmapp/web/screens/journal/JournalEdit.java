package com.company.bpmapp.web.screens.journal;

import com.haulmont.cuba.core.global.BeanLocator;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.components.validation.RegexpValidator;
import com.haulmont.cuba.gui.screen.*;
import com.company.bpmapp.entity.Journal;
import sun.misc.resources.Messages;

import javax.inject.Inject;

@UiController("bpmapp_Journal.edit")
@UiDescriptor("journal-edit.xml")
@EditedEntityContainer("journalDc")
@LoadDataBeforeShow
public class JournalEdit extends StandardEditor<Journal> {

    @Inject
    private TextField<String> numberFormatField;

    @Inject
    private BeanLocator beanLocator;

    @Subscribe("numberFormatField")
    public void onNumberFormatFieldValueChange(HasValue.ValueChangeEvent<String> event) {
        RegexpValidator regexpValidator = beanLocator.getPrototype(RegexpValidator.NAME, "Исх - *(?<Date>((DD)?\\.)?(MM)\\.(YY)?YY) - №");
        numberFormatField.addValidator(regexpValidator);

    }

}