package com.sheilaswheels.domain.enumType;

public enum CarKeptOvernight {
    DRIVEAWAY("Driveway"),
    GARAGE("Garage"),
    ROADOUTSIDERESIDENCE("Road Outside Residence"),
    ROADNOTOUTSIDERESIDENCE("Road Outside Not My Residence "),
    PRIVATECARPARK("Private Car Park"),
    PUBLICCARPARK("Public car Park"),
    CARPORT("Car Port"),
    OTHER("Other"),
    GARAGEWORK("Garage - Work"),
    STREETWORK("Street - Work"),
    SECURECARPARKWORK("Secure Car Park - Work"),
    PUBLICCARPARKWORK("Public Car park - Work"),
    OPENCARPARKWORK("Other Car Park - Work"),
    OTHERWORK("Other Work");


    private String value;

    CarKeptOvernight(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static CarKeptOvernight get(String value) {
        for (CarKeptOvernight v : values()) {
            if (v.getValue().equalsIgnoreCase(value))
                return v;
        } throw new IllegalArgumentException();
    }
}


