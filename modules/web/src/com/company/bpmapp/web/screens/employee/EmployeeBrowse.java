package com.company.bpmapp.web.screens.employee;

import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.bpmapp.entity.Employee;

import javax.inject.Inject;
import java.util.Map;

@UiController("bpmapp_Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
@LoadDataBeforeShow
public class EmployeeBrowse extends StandardLookup<Employee> {
    @Inject
    private CollectionLoader<Employee> employeesDl;






    







}