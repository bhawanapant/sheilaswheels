package com.esure.motorinsurance.sheilaswheels.domain.enumType;

public enum MaritalStatus {
    MARRIED("Married/Civil Partnership"),
    SINGLE("Single"),
    LIVING("Living with Partner"),
    WIDOWED("Widowed"),
    DIVORCED("Divorced");

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

    public static MaritalStatus get(String value) {
        for (MaritalStatus v :values()){
            if (v.getValue().equalsIgnoreCase(value))
                return v;
        } throw new IllegalArgumentException();
    }
}
