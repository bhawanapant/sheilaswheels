package com.sheilaswheels.domain;

import com.sheilaswheels.domain.enumType.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

import static com.sheilaswheels.domain.enumType.AccessToAnyVehicle.NO;
import static com.sheilaswheels.domain.enumType.CarInHousehold.TWO;
import static com.sheilaswheels.domain.enumType.EmploymentStatus.EMPLOYED;
import static com.sheilaswheels.domain.enumType.ExpDrivingAnotherVehicle.NONE;
import static com.sheilaswheels.domain.enumType.Gender.FEMALE;
import static com.sheilaswheels.domain.enumType.LicenceType.FULLUKLICENCE;
import static com.sheilaswheels.domain.enumType.MaritalStatus.MARRIED;
import static com.sheilaswheels.domain.enumType.NCDYear.ONEYEAR;
import static com.sheilaswheels.domain.enumType.ResidentialStatus.HOMEOWNER;
import static com.sheilaswheels.domain.enumType.Title.MRS;
import static com.sheilaswheels.domain.enumType.YearOfClaimFreeOnVehicle.UNDERONEYEAR;

/**
     * Created by bhawana on 24/04/2017.
     */
    @Builder
    @Data
    public class YourDetails {

        private CustomerDetails customerDetails;
        private MotorClaims motorClaims;
        private AdditionalPartner additionalPartners;
        private AboutYourCar aboutYourCar;

        public static class YourDetailsBuilder {
            private CustomerDetails customerDetails = CustomerDetails.builder().build();
            private MotorClaims motorClaims = MotorClaims.builder().build();
            private AdditionalPartner additionalPartners = AdditionalPartner.builder().build();
            private AboutYourCar aboutYourCar = AboutYourCar.builder().build();
        }


        @Builder
        @Data
        public static class CustomerDetails {
            private String firstName;
            private String lastName;
            private String occupation;
            private String industry;
            private boolean secondOccupation;
            private String phoneNumber;
            private String additionalPhoneNumber;
            private String emailAddress;
            private EmploymentStatus employmentStatus;
            private NoOfChildrenAtAddress childrenatAddress;
            private ResidentialStatus residentialStatus;
            private LocalDate coverStartDate;
            private Title title;
            private Gender gender;
            private LocalDate dob;
            private MaritalStatus maritalStatus;
            private boolean ukResident;
            private String postcode;
            private boolean isFirstTimeBuyer;

            public static class CustomerDetailsBuilder {
                private String firstName = "Bhawana";
                private String lastName = "Pant";
                private String occupation = "Computer Engineer";
                private String industry = "Insurance";
                private String phoneNumber = "08998478869";
                private String additionalPhoneNumber = "07667898878";
                private String emailAddress = "no.one@esure.com";
                private EmploymentStatus employmentStatus = EMPLOYED;
                private boolean secondOccupation = false;
                private boolean ukResident = true;
                private NoOfChildrenAtAddress childrenatAddress = NoOfChildrenAtAddress.TWO;
                private ResidentialStatus residentialStatus = HOMEOWNER;
                private LocalDate coverStartDate = LocalDate.now();
                private Title title = MRS;
                private Gender gender = FEMALE;
                private LocalDate dob = LocalDate.of(1985, 04, 25);
                private MaritalStatus maritalStatus = MARRIED;
                private boolean isFirstTimeBuyer = true;
                private String postcode = "TW18 4EZ";

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
            private boolean addPartner;
            private boolean isMarriedToMainDriver;

            public static class AdditionalParterBuilder {
                private boolean addPartner = false;
                private boolean isMarriedToMainDriver = true;
            }
        }

        @Builder
        @Data
        public static class AboutYourCar{
            private CarInHousehold carInHousehold;
            private AccessToAnyVehicle accessOfVehicle;
            private LicenceType licenceType;
            private LicenceHeldYear licenceHeldYear;
            private LicenceHeldMonth licenceHeldMonth;
            private NCDYear ncdYear;
            private LocalDate coverStartDate;
            private ExpDrivingAnotherVehicle expDrivingAnotherVehicle;
            private YearOfClaimFreeOnVehicle yearOfClaimFreeOnVehicle;
            private String registrationNo;

            public static class AboutYourCarBuilder{
                private CarInHousehold carInHousehold = TWO;
                private AccessToAnyVehicle accessOfVehicle = NO;
                private LicenceType licenceType = FULLUKLICENCE;
                private LicenceHeldYear licenceHeldYear = LicenceHeldYear.ONEYEAR;
                private LicenceHeldMonth licenceHeldMonth = LicenceHeldMonth.ONEMONTH;
                private NCDYear ncdYear = ONEYEAR;
                private LocalDate coverStartDate = LocalDate.of(2017, 04, 02);
                private ExpDrivingAnotherVehicle expDrivingAnotherVehicle = NONE;
                private YearOfClaimFreeOnVehicle yearOfClaimFreeOnVehicle = UNDERONEYEAR;
                private String registrationNo = "BL64 PKO";
            }
        }

    }

