package com.sheilaswheels.domain;

import com.sheilaswheels.domain.enumType.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

import static com.sheilaswheels.domain.enumType.AccessToAnyVehicle.NO;
import static com.sheilaswheels.domain.enumType.BoostCover.MOTORLEGALPROTECTION;
import static com.sheilaswheels.domain.enumType.CarInHousehold.TWO;
import static com.sheilaswheels.domain.enumType.EmploymentStatus.EMPLOYED;
import static com.sheilaswheels.domain.enumType.ExpDrivingAnotherVehicle.NONE;
import static com.sheilaswheels.domain.enumType.Gender.FEMALE;
import static com.sheilaswheels.domain.enumType.LicenceType.FULLUKLICENCE;
import static com.sheilaswheels.domain.enumType.MaritalStatus.MARRIED;
import static com.sheilaswheels.domain.enumType.NCDYear.EIGHTYEARS;
import static com.sheilaswheels.domain.enumType.ResidentialStatus.HOMEOWNER;
import static com.sheilaswheels.domain.enumType.Title.MRS;
import static com.sheilaswheels.domain.enumType.YearOfClaimFreeOnVehicle.UNDERONEYEAR;

/**
 * Created by bhawana on 16/05/2017.
 */
@Builder
@Data
public class InsuranceData {
    private YourDetails yourDetails;
    private AboutYou aboutYou;
    private YourCar yourCar;
    private MotorClaims motorClaims;
    private AdditionalPartner additionalPartner;
    private BoostInsuranceCover boostInsuranceCover;

        public static class InsuranceData1Builder{
            private YourDetails yourDetails = YourDetails.builder().build();
            private AboutYou aboutYou = AboutYou.builder().build();
            private YourCar yourCar = YourCar.builder().build();
            private MotorClaims motorClaims = MotorClaims.builder().build();
            private AdditionalPartner additionalPartner = AdditionalPartner.builder().build();
            private BoostInsuranceCover boostInsuranceCover = BoostInsuranceCover.builder().build();
        }

    @Builder
    @Data
    public static class YourDetails {
        private Title title;
        private String firstName;
        private String lastName;
        private String emailAddress;
        private String phoneNumber;
        private String additionalPhoneNumber;
        private boolean addPartner;
        private boolean isMainDriver;
        private boolean isFirstTimeBuyer;


        public static class YourDetailsBuilder{
                private Title title = MRS;
                private String firstName = "Bhawana";
                private String lastName = "Pant";
                private String emailAddress = "no.one@esure.com";
                private String phoneNumber = "08998478869";
                private String additionalPhoneNumber = "07667898878";
                private boolean addPartner = false;
                private boolean isMainDriver = true;
                private boolean isFirstTimeBuyer = true;
        }
    }

    @Builder
    @Data
    public static class AboutYou{
        private LocalDate dob;
        private boolean ukResident;
        private EmploymentStatus employmentStatus;
        private String occupation;
        private String industry;
        private boolean secondOccupation;
        private Gender gender;
        private MaritalStatus maritalStatus;
        private NoOfChildrenAtAddress childrenatAddress;
        private ResidentialStatus residentialStatus;
        private CarInHousehold carInHousehold;
        private AccessToAnyVehicle accessOfVehicle;
        private LicenceType licenceType;
        private LicenceHeldYear licenceHeldYear;
        private LicenceHeldMonth licenceHeldMonth;
        private NCDYear ncdYear;
        private LocalDate coverStartDate;
        private LocalDate coverEndDate;
        private String registrationNo;
        private String postcode;

            public static class AboutYouBuilder{
                private LocalDate dob = LocalDate.of(1985, 04, 25);
                private boolean ukResident = true;
                private EmploymentStatus employmentStatus = EMPLOYED;
                private String occupation = "Computer Engineer";
                private String industry = "Insurance";
                private boolean secondOccupation = false;
                private Gender gender = FEMALE;
                private MaritalStatus maritalStatus = MARRIED;
                private NoOfChildrenAtAddress childrenatAddress = NoOfChildrenAtAddress.TWO;
                private ResidentialStatus residentialStatus = HOMEOWNER;
                private CarInHousehold carInHousehold = TWO;
                private AccessToAnyVehicle accessOfVehicle = NO;
                private LicenceType licenceType = FULLUKLICENCE;
                private LicenceHeldYear licenceHeldYear = LicenceHeldYear.FOURYEARS;
                private LicenceHeldMonth licenceHeldMonth = LicenceHeldMonth.ONEMONTH;
                private NCDYear ncdYear = EIGHTYEARS;
                private LocalDate coverStartDate = LocalDate.of(2017, 04, 02);
                private LocalDate coverEndDate;
                private String registrationNo = "BL64 PKO";
                private String postcode = "TW18 4EZ";
            }
        }

    @Builder
    @Data
    public static class YourCar {
        private String carMaker;
        private String carModel;
        private String fuelType;
        private String transmissionType;
        private LocalDate carRegistrationDate;
        private int estimateValue;
        private Mileage mileage;
        private CarKeptOvernight carKeptOvernight;
        private LocalDate carPurchaseDate;
        private SecurityDevice securityDevice;
        private LegalOwnerOfCar legalOwnerOfCar;
        private RegisterKeeperOfCar registerKeeperOfCar;
        private boolean isTrackingDeviceFitted;
        private UseOfCar useOfCar;
        private CoverLevel coverLevel;
        private boolean CarModified;
        private boolean isCarKeptDiffPostCode;
        private ExpDrivingAnotherVehicle expDrivingAnotherVehicle;
        private YearOfClaimFreeOnVehicle yearOfClaimFreeOnVehicle;

        public static class YourCarBuilder {
                private String carMaker = "";
                private String carModel = "";
                private String fuelType = "";
                private String transmissionType = "";
                private LocalDate carRegistrationDate = LocalDate.of(2016, 01, 20);
                private int estimateValue = 7799;
                private Mileage mileage = Mileage.UPTO17000;
                private CarKeptOvernight carKeptOvernight = CarKeptOvernight.DRIVEAWAY;
                private LocalDate carPurchaseDate = LocalDate.of(2017, 04, 25);
                private SecurityDevice securityDevice = SecurityDevice.NONEFITTED;
                private LegalOwnerOfCar legalOwnerOfCar = LegalOwnerOfCar.PROPOSER;
                private RegisterKeeperOfCar registerKeeperOfCar = RegisterKeeperOfCar.PROPOSER;
                private boolean isTrackingDeviceFitted = false;
                private UseOfCar useOfCar = UseOfCar.SOCIALDOMESTICANDPLEASURE;
                private CoverLevel coverLevel = CoverLevel.COMPREHENSIVE;
                private boolean CarModified = false;
                private boolean isCarKeptDiffPostCode = false;
                private ExpDrivingAnotherVehicle expDrivingAnotherVehicle = NONE;
                private YearOfClaimFreeOnVehicle yearOfClaimFreeOnVehicle = UNDERONEYEAR;
            }
        }

    @Builder
    @Data
    public static class MotorClaims {
        private boolean motorClaims;
        private boolean motorConviction;

        public static class MotorClaimsBuilder{
            boolean motorClaims = false;
            boolean motorConviction = false;

        }
    }

    @Builder
    @Data
    public static class AdditionalPartner {
        private boolean isAdditionalDriver;
        private boolean additionalDriverClaims;
        private boolean additionalDriverConviction;

        public static class AdditionalParterBuilder {
            private boolean isAdditionalDriver = false;
            private boolean additionalDriverClaims = false;
            private boolean additionalDriverConviction = false;
        }
    }

    @Builder
    @Data
    public static class BoostInsuranceCover{
        private double monthlyCost;
        private double annualPremium;
        private BoostCover boostCover;
        private boolean ncdProtection;
        private BreakDown breakDown;

        public static class BoostInsuranceCoverBuilder{
            private double monthlyCost = 0.0;
            private double annualPremium = 0.0;
            private BoostCover boostCover = MOTORLEGALPROTECTION;
            private boolean ncdProtection = false;
            private BreakDown breakDown = BreakDown.RSA_HR_RECOVERY;
        }
    }
}
