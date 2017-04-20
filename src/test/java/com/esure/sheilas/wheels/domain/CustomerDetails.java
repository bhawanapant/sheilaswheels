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
    private String Surname;
    private Gender gender;
    private LocalDate dob;
    private MaritalStatus maritalstatus;
    private String occupation;
    private int phonenumber;
    private String additionalphonenumber;
    private String emailaddress;
    private String postcode;
    private boolean firsttimebuyer;
    private String coverstartdate;

    public static class CustomerDetailsBuilder {
        private Title tile = Title.Mrs;
        firstName = "Bhawana";
        SurName = "Pant";
        EmailAddress = "upadhyay.bhawana1@gmail.com";
        phonenumber = 0987876756;
       // private LocalDate dob = LocalDate.of(1980, 11, 25);
        
    }
}

	