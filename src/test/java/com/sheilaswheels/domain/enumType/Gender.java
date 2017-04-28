package com.sheilaswheels.domain.enumType;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private String value;

    Gender(String value) {
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


