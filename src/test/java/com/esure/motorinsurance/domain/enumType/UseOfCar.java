package com.esure.motorinsurance.domain.enumType;

public enum UseOfCar {
    SOCIALDOMESTICANDPLEASURE("Social, Domestic and Pleasure"),
    SOCIALCOMMUTETOSINGLEPLACE("Social + commute to single place of work/study"),
    SDPCANDBUSINESS("SDP&C + Business use by you"),
    SDPCANDBUSINESSYOUANDSPOUSE("SDP&C + Business use by you and/your spouse"),
    SDPCANDBUSINESSBYYOUORANYDRIVER("SDP&C + Business use by you/any driver"),
    COMMERCIALTRAVELLING("Commercial travelling");

    private String value;

    UseOfCar(String value) {
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


