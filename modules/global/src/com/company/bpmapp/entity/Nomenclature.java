package com.company.bpmapp.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "BPMAPP_NOMENCLATURE")
@Entity(name = "bpmapp_Nomenclature")
@NamePattern("%s|name")
public class Nomenclature extends StandardEntity {
    private static final long serialVersionUID = 5874289136142907751L;

    @NotNull
    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "NAME")
    private String name;

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