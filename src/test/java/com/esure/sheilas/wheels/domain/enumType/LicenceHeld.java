package com.esure.sheilas.wheels.domain.enumType;

public enum LicenceHeld {
    NO("NO"),
    YESACCESSTO("Yes (access to)"),
    YESOWN("Yes (own)"),
    YESNAMEDDRIVER("Yes (Named driver)");

    private String value;

    LicenceHeld(String value) {
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


