package com.sheilaswheels.domain.enumType;

public enum YearOfClaimFreeOnVehicle {
    UNDERONEYEAR("Under 1 Year"),
    ONEPLUSYEAR("1+ Year"),
    FOURPLUSYEARS("4+ Years"),
    FIVEPLUSYEARS("5+ Years");

    private String value;

    YearOfClaimFreeOnVehicle(String value) {
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


