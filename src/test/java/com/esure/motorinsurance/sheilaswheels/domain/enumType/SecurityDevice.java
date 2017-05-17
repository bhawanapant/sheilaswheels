package com.esure.motorinsurance.sheilaswheels.domain.enumType;

public enum SecurityDevice {
    NONEFITTED("None Fitted"),
    STANDARDFITALARMANDIMMOBILISER("Standard fit alarm & immobiliser"),
    STANDARDFITIMMOBILISER("Standard fit immobiliser"),
    AFTERMARKETALAMANDIMMOBILISER("After market alarm & immobiliser"),
    AFTERMARKETIMMOBILISER("After market immobiliser");


    private String value;

    SecurityDevice(String value) {
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


