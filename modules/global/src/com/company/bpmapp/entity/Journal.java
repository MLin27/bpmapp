package com.company.bpmapp.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "BPMAPP_JOURNAL")
@Entity(name = "bpmapp_Journal")
@NamePattern("%s|name")
public class Journal extends StandardEntity {
    private static final long serialVersionUID = 8827904158169438723L;

    @NotNull
    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NUMBER_FORMAT")
    private String numberFormat;

    @Column(name = "DIGIT_AMOUNT")
    private Integer digitAmount;

    public Integer getDigitAmount() {
        return digitAmount;
    }

    public void setDigitAmount(Integer digitAmount) {
        this.digitAmount = digitAmount;
    }

    public String getNumberFormat() {
        return numberFormat;
    }

    public void setNumberFormat(String numberFormat) {
        this.numberFormat = numberFormat;
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