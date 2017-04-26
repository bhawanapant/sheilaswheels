package com.esure.sheilas.wheels.domain;

import com.esure.sheilas.wheels.domain.enumType.Gender;
import com.esure.sheilas.wheels.domain.enumType.MaritalStatus;
import com.esure.sheilas.wheels.domain.enumType.Title;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

import static com.esure.sheilas.wheels.domain.enumType.Gender.FEMALE;
import static com.esure.sheilas.wheels.domain.enumType.MaritalStatus.MARRIED;
import static com.esure.sheilas.wheels.domain.enumType.Title.MRS;

    /**
     * Created by bhawana on 24/04/2017.
     */
    @Builder
    @Data
    public class YourDetails {

        private CustomerDetails customerDetails;
        private MotorClaims motorClaims;
        private AdditionalPartner additionalPartners;

        public static class YourDetailsBuilder {
            private CustomerDetails customerDetails = CustomerDetails.builder().build();
            private MotorClaims motorClaims = MotorClaims.builder().build();
            private AdditionalPartner additionalPartners = AdditionalPartner.builder().build();
        }


        @Builder
        @Data
        public static class CustomerDetails {
            private String firstName;
            private String lastName;
            private String occupation;
            private String industry;
            private String phoneNumber;
            private String additionalPhoneNumber;
            private String emailAddress;
            private String postCode;
            private LocalDate coverStartDate;
            private Title title;
            private Gender gender;
            private LocalDate dob;
            private MaritalStatus maritalStatus;
            private boolean isFirstTimeBuyer;

            public static class CustomerDetailsBuilder {
                private String firstName = "Bhawana";
                private String lastName = "Pant";
                private String occupation = "Computer Engineer";
                private String industry = "Insurance";
                private String phoneNumber = "08998478869";
                private String additionalPhoneNumber = "07667898878";
                private String emailAddress = "no.one@esure.com";
                private String postCode = "TW18 4EZ";
                private LocalDate coverStartDate = LocalDate.now();
                private Title title = MRS;
                private Gender gender = FEMALE;
                private LocalDate dob = LocalDate.of(1985, 04, 13);
                private MaritalStatus maritalStatus = MARRIED;
                private boolean isFirstTimeBuyer = true;
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
                boolean addPartner = false;
                boolean isMarriedToMainDriver = true;
            }
        }

    }

