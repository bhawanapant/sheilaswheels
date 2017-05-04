package com.sheilaswheels.domain.enumType;

public enum EmploymentStatus {
    EMPLOYED("Employed"),
    INEDUCATION("In Education"),
    SELFEMPLOYED("Self Employed"),
    VOLUNTARY("Voluntary"),
    INDEPENDENTMEANS("Independent Means"),
    NOTEMPLOYED("Not Employed"),
    NOTEMPLOYEDDUETODISABILITY("Not Employed Due to Disability"),
    RETIRED("Retired"),
    HOUSEWIFEANDHUSBAND("Housewife / House Husband");

    private String value;

    EmploymentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static EmploymentStatus get(String value) {
        for (EmploymentStatus v : values()) {
            if (v.getValue().equalsIgnoreCase(value))
                return v;
        } throw new IllegalArgumentException();
    }
}


