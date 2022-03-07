package com.company.bpmapp.web.screens.employee;

import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.bpmapp.entity.Employee;
import com.haulmont.cuba.security.entity.User;

import javax.inject.Inject;
import java.util.Collection;

@UiController("bpmapp_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
@LoadDataBeforeShow
public class EmployeeEdit extends StandardEditor<Employee> {

    @Inject
    private InstanceContainer<Employee> employeeDc;
    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private PickerField<User> userField;



    @Subscribe(id = "employeeDc", target = Target.DATA_CONTAINER)
    public void onEmployeeDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<Employee> event) {
        if("user".equals(event.getProperty())){
            event.getItem().setFirstName(event.getItem().getUser().getFirstName());
            event.getItem().setLastName(event.getItem().getUser().getLastName());
        }
    }








}