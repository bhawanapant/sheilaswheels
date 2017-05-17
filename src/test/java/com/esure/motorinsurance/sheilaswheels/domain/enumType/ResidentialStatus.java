package com.esure.motorinsurance.sheilaswheels.domain.enumType;

public enum ResidentialStatus {
    HOMEOWNER("Home owner"),
    RENTING("Renting"),
    LIVINGWITHPARENTS("Living with parents"),
    HOUSINGASSOCIATION("Housing association"),
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

    public static ResidentialStatus get(String value) {
        for (ResidentialStatus v : values()) {
            if (v.getValue().equalsIgnoreCase(value))
                return v;
        } throw new IllegalArgumentException();
    }
}


