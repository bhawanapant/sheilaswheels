package com.esure.sheilas.wheels.domain;

import com.esure.sheilas.wheels.domain.enumType.MaritalStatus;
import com.esure.sheilas.wheels.domain.enumType.Title;
import com.esure.sheilas.wheels.domain.enumType.Gender;
import lombok.Builder;

import java.time.LocalDate;

import static com.esure.sheilas.wheels.domain.enumType.Gender.FEMALE;

@Builder
public class CustomerDetails {
    private Title title;
    private String firstname;
    private String lastname;
    private Gender gender;
    private LocalDate dob;
    private MaritalStatus maritalstatus;
    private String occupation;
    private String phonenumber;
    private String additionalphonenumber;
    private String emailaddress;
    private String postcode;
    private boolean firsttimebuyer;
    private String coverstartdate;

    public static class CustomerDetailsBuilder {
        private Title tile = Title.Mrs;
        private String firstName = "Bhawana";
        private String lastName = "Pant";
        private Gender gender = FEMALE;
        private LocalDate dob = LocalDate.of(1980, 11, 25);
    }
}

