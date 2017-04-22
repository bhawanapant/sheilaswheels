package com.esure.sheilas.wheels.domain.enumType;

public enum NCDYear {
    NONE("None"),
    ONEYEAR("1 Year"),
    EIGHTYEARS("8 Years"),
    TWENTYYEARS("20 Years");

    private String value;

    NCDYear(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}


