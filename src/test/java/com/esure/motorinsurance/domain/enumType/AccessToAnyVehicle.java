package com.esure.motorinsurance.domain.enumType;

public enum AccessToAnyVehicle {
    NO("No"),
    YESACCESSTO("Yes (access to)"),
    YESOWN("Yes (own)"),
    YESNAMEDDRIVER("Yes (Named driver)");

    private String value;

    AccessToAnyVehicle(String value) {
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


