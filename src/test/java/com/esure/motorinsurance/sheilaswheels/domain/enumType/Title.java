package com.esure.motorinsurance.sheilaswheels.domain.enumType;


public enum Title {
    MRS("Mrs"),
    MISS("Miss"),
    MS("Ms"),
    DR("Dr"),
    PROFESSOR("Professor"),
    LADY("Lady"),
    DAME("Dame"),
    RT_HONOURABLE("Rt. Honourable"),
    MR("Mr"),
    REVEREND("Reverend"),
    SIR("Sir"),
    LORD("Lord");
    private String value;

    Title(String value) {this.value = value;}

    public String getValue(){ return value;}

    @Override
    public String toString() {
        return this.getValue();
    }

    public static Title get(String value) {
        for (Title v : values()) {
            if (v.getValue().equalsIgnoreCase(value))
                return v;
        } throw new IllegalArgumentException();
    }
}
