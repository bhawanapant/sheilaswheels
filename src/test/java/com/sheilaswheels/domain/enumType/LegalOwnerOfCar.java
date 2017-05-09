package com.sheilaswheels.domain.enumType;

public enum LegalOwnerOfCar {
    PROPOSER("Proposer"),
    SPOUSEANDBUSINESSPARTNER("Spouse/Civil Partner/Partner"),
    PERSONALLEASEPLAN("Personal Lease Plan"),
    BUSINESSLEASE("Business Lease"),
    COMPANY("Company"),
    LONGTERMHIRE("Long Term Hire"),
    SONORDAUGHETR("Son / Daughter"),
    PARENT("Parent"),
    OTHERFAMILYMEMBER("Other Family Member"),
    OTHER("Other"),
    UNKNOWN("Unknown");

    private String value;

    LegalOwnerOfCar(String value) {
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


