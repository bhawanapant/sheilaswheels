package com.sheilaswheels.domain.enumType;

public enum ResidentialStatus {
    HOMEOWNER("Home owner"),
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

