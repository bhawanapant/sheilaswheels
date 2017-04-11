package com.esure.sheilas.wheels.domain.enumType;

public enum MaritalStatus {

    MARRIED("Married/Civil Patnership"),
    SINGLE("Single");

    private String value;

    MaritalStatus(String value) {
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
