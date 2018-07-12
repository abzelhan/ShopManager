package com.abzal.project.model;

public enum RoleEnum {

    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    RoleEnum(String value){
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }


}
