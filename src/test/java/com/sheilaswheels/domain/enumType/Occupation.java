package com.sheilaswheels.domain.enumType;

public enum Occupation {
    MATURESTUDENT("Mature Student"),
    MEDICALSTUDENT("Medical Student"),
    STUDENT("Student"),
    STUDENTFOREIGN("Student - Foreign"),
    STUDENTNURSE("Student Nurse");

    private String value;

    Occupation(String value) {
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


