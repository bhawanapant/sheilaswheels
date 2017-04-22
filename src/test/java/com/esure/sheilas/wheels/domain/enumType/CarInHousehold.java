package com.esure.sheilas.wheels.domain.enumType;

public enum CarInHousehold {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVEORMORE("5 or more");

    private String value;

    CarInHousehold(String value) {
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


