package com.esure.sheilas.wheels.domain.enumType;

public enum ResidentialStatus {
    HOMEOWNER("Home Owner"),
    RENTING("Renting"),
    LIVINGWITHPARENTS("Living with Parents"),
    HOUSINGASSOCIATION("Housing Association"),
    OTHER("Other");

    private String value;

    ResidentialStatus(String value) {
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


