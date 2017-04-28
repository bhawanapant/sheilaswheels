package com.sheilaswheels.domain.enumType;

public enum LicenceHeldYear {
    LESSTHANONEYEAR("Less than 1 year"),
    ONEYEAR("1 Year"),
    FOURYEARS("4 Years"),
    SEVENYEARS("7 Years");

    private String value;

    LicenceHeldYear(String value) {
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


