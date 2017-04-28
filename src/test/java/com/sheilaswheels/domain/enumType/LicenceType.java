package com.sheilaswheels.domain.enumType;

public enum LicenceType {
    FULLUKLICENCE("Full UK Licence"),
    FULLUKLICENCEAUTOMATIC("Full UK Licence (Automatics only)"),
    PROUKLICENCE("Provisional UK Licence"),
    FULLECEEALICENCE("Full EC/EEA Licence"),
    PROECEEALICENCE("Provisional EC/EEA Licence"),
    OUTSIDEUKECEEA("Licence issued outside UK/EC/EEA"),
    OTHER("Other");

    private String value;

    LicenceType(String value) {
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


