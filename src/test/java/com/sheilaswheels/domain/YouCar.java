package com.sheilaswheels.domain;

import com.sheilaswheels.domain.enumType.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/**
 * Created by bhawana on 08/05/2017.
 */
@Builder
@Data
public class YouCar {
    private LegalOwnerOfCar legalOwnerOfCar;
    private RegisterKeeperOfCar registerKeeperOfCar;
    private UseOfCar useOfCar;
    private SecurityDevice securityDevice;
    private int estimateValue;
    private boolean isTrackingDeviceFitted;
    private Mileage mileage;
    private boolean isCarKeptDiffPostCode;
    private LocalDate carPurchaseDate;
    private LocalDate carRegistrationDate;
    private CarKeptOvernight carKeptOvernight;
    private CoverLevel coverLevel;
    private boolean CarModified;
    private String carDetails;

        public static class YouCarBuilder{
            private LegalOwnerOfCar legalOwnerOfCar = LegalOwnerOfCar.PROPOSER;
            private RegisterKeeperOfCar registerKeeperOfCar = RegisterKeeperOfCar.PROPOSER;
            private UseOfCar useOfCar = UseOfCar.SOCIALDOMESTICANDPLEASURE;
            private SecurityDevice securityDevice = SecurityDevice.NONEFITTED;
            private int estimateValue = 7799;
            private boolean isTrackingDeviceFitted = false;
            private Mileage mileage = Mileage.UPTO17000;
            private boolean isCarKeptDiffPostCode = false;
            private LocalDate carPurchaseDate = LocalDate.of(2017, 04, 25);
            private CarKeptOvernight carKeptOvernight = CarKeptOvernight.DRIVEAWAY;
            private LocalDate carRegistrationDate = LocalDate.of(2016, 01, 20);
            private CoverLevel coverLevel = CoverLevel.COMPREHENSIVE;
            private boolean CarModified = false;
            private String carDetails;
        }
    }
