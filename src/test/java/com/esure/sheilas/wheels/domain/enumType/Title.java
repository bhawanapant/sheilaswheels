package com.esure.sheilas.wheels.domain.enumType;


public enum Title {
    MRS("Mrs"),
    MISS("Miss"),
    MS("Ms"),
    DR("Dr"),
    PROFESSOR("Professor"),
    LADY("Lady"),
    DAME("Dame"),
    RTHONOURABLE("Rt Honourable"),
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
}
