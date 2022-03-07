package com.company.bpmapp.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum DocumentState implements EnumClass<String> {

    NEW("New"),
    IN_APP("In approval"),
    IN_SIGN("In signing"),
    IN_REWORK("In rework"),
    REG("Registered");

    private String id;

    DocumentState(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static DocumentState fromId(String id) {
        for (DocumentState at : DocumentState.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}