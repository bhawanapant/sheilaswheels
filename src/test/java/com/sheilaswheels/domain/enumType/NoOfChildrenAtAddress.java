package com.sheilaswheels.domain.enumType;

public enum NoOfChildrenAtAddress {
    NONE("None"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOURORMORE("4 or more");

    private String value;

    NoOfChildrenAtAddress(String value) {
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


