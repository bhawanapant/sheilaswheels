package com.esure.sheilas.wheels.domain;

import lombok.Builder;

/**
 * Created by bhawana on 22/04/2017.
 */
@Builder
public class AdditionalPartner {
    private boolean additionalpartner;
    private boolean marriedtomaindriver;

    public static class AdditionalParterBuilder{
        boolean additionalpartner = false;
        boolean marriedtomaindriver = true;
    }
}
