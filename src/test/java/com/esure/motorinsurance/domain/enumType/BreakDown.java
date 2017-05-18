package com.esure.motorinsurance.domain.enumType;

/**
 * Created by bhawana on 11/05/2017.
 */
public enum BreakDown {
    ROADSIDEASSISTANCE("Roadside Assistance"),
    RSA_HOMERESCUE("Roadside Assistance and Home Rescue"),
    RSA_HR_RECOVERY("Roadside Assistance, Home Rescue and Recovery"),
    NOBREAKDOWNCOVER("No breakdown cover is required");

    private String value;

    BreakDown(String value) {
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
