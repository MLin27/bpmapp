package com.company.bpmapp.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@PublishEntityChangedEvents
@Table(name = "BPMAPP_SUBDIVISION")
@Entity(name = "bpmapp_Subdivision")
@NamePattern("%s|name")
public class Subdivision extends StandardEntity {
    private static final long serialVersionUID = 6839838981431231339L;

    @NotNull
    @Column(name = "CODE", nullable = false)
    private String code;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HEAD_OF_DEPARTMENT_ID")
    private Employee headOfDepartment;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @JoinColumn(name = "LEADING_SUBDIVISION_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Subdivision leadingSubdivision;

    public Employee getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(Employee headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public void setLeadingSubdivision(Subdivision leadingSubdivision) {
        this.leadingSubdivision = leadingSubdivision;
    }

    public Subdivision getLeadingSubdivision() {
        return leadingSubdivision;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}