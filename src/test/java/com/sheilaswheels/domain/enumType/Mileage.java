package com.sheilaswheels.domain.enumType;

public enum Mileage {
    UPTO1000("0 - 1000 miles"),
    UPTO9000("8001 - 9000 miles"),
    UPTO17000("16001 - 17000 miles"),
    UPTO40000("30001 - 40000 miles"),
    OVER60000("Over 60000 miles");

    private String value;

    Mileage(String value) {
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


