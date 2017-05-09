package com.sheilaswheels.domain.enumType;

public enum CoverLevel {
    COMPREHENSIVE("Comprehensive"),
    THIRDPARTYFIREANDTHREFT("Third Party, Fire and Theft");

    private String value;

    CoverLevel(String value) {
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


