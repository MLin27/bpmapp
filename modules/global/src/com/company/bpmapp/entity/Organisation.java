package com.company.bpmapp.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "BPMAPP_ORGANISATION")
@Entity(name = "bpmapp_Organisation")
public class Organisation extends StandardEntity {
    private static final long serialVersionUID = -1408222486193991315L;

    @NotNull
    @Column(name = "CODE", nullable = false)
    private String code;

    @NotNull
    @Column(name = "SHORT_NAME", nullable = false)
    private String shortName;

    @NotNull
    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "FISCAL_ADDRESS")
    private String fiscalAddress;

    @Column(name = "ADDRESS")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFiscalAddress() {
        return fiscalAddress;
    }

    public void setFiscalAddress(String fiscalAddress) {
        this.fiscalAddress = fiscalAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}