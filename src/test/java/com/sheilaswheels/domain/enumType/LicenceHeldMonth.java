package com.sheilaswheels.domain.enumType;

public enum LicenceHeldMonth {
    LESSTHANONEMONTH("Less than 1 month"),
    ONEMONTH("1 month"),
    FOURMONTHS("4 months"),
    SEVENMONTHS("7 months");

    private String value;

    LicenceHeldMonth(String value) {
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


