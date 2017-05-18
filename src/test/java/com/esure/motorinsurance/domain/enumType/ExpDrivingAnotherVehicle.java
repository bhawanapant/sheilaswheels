package com.esure.motorinsurance.domain.enumType;

public enum ExpDrivingAnotherVehicle {
    NONE("None"),
    OWNOTHERCAR("Own Other Car"),
    NAMEDDRIVER("Name Driver"),
    COMPANYCAR("Company Car"),
    VAN("Van"),
    MOTORCYCLE("Motorcycle");

    private String value;

    ExpDrivingAnotherVehicle(String value) {
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


