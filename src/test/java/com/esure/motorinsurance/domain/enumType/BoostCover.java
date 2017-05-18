package com.esure.motorinsurance.domain.enumType;

/**
 * Created by bhawana on 09/05/2017.
 */
public enum BoostCover {
    FULLPROTECTION("Full Protection"),
    JUSTINCASE("Just in case"),
    MOTORLEGALPROTECTION("Motor Legal Protection"),
    NOEXTRACOVER("No extra cover");

    private String value;

    BoostCover(String value) {
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
