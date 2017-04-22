package com.esure.sheilas.wheels.domain;

import lombok.Builder;

/**
 * Created by bhawana on 22/04/2017.
 */
@Builder
public class MotorClaims {
    private boolean motorclaims;
    private boolean motorconviction;

    public static class MotorClaimsBuilderDRE{
        boolean motorclaims = false;
        boolean motorconviction = false;

    }
}
