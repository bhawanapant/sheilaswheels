//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.esure.sheilas.wheels.domain;

import com.esure.sheilas.wheels.domain.enumType.Gender;
import com.esure.sheilas.wheels.domain.enumType.MaritalStatus;
import com.esure.sheilas.wheels.domain.enumType.Title;

import java.time.LocalDate;

import static com.esure.sheilas.wheels.domain.enumType.Gender.FEMALE;
import static com.esure.sheilas.wheels.domain.enumType.MaritalStatus.MARRIED;
import static com.esure.sheilas.wheels.domain.enumType.Title.MRS;

public class CustomerDetails {
    private String firstname;
    private String lastname;
    private String occupation;
    private String industry;
    private String phonenumber;
    private String additionalphonenumber;
    private String emailaddress;
    private String postcode;
    private LocalDate coverstartdate;
    private Title title;
    private Gender gender;
    private LocalDate dob;
    private MaritalStatus maritalstatus;
    private boolean firsttimebuyer;

    private CustomerDetails(CustomerDetailsBuilder customerdetailbuilder) {
        this.firstname = customerdetailbuilder.firstname;
        this.lastname = customerdetailbuilder.lastname;
        this.occupation = customerdetailbuilder.occupation;
        this.industry = customerdetailbuilder.industry;
        this.phonenumber = customerdetailbuilder.phonenumber;
        this.additionalphonenumber = customerdetailbuilder.additionalphonenumber;
        this.emailaddress = customerdetailbuilder.emailaddress;
        this.postcode = customerdetailbuilder.postcode;
        this.coverstartdate = customerdetailbuilder.coverstartdate;
        this.title = customerdetailbuilder.title;
        this.gender = customerdetailbuilder.gender;
        this.dob = customerdetailbuilder.dob;
        this.maritalstatus = customerdetailbuilder.maritalstatus;
        this.firsttimebuyer = customerdetailbuilder.firsttimebuyer;
    }


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getAdditionalphonenumber() {
        return additionalphonenumber;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public String getPostcode() {
        return postcode;
    }

    public LocalDate getCoverstartdate() {
        return coverstartdate;
    }

    public Title getTitle() {
        return title;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public MaritalStatus getMaritalstatus() {
        return maritalstatus;
    }

    public boolean isFirsttimebuyer() {
        return firsttimebuyer;
    }

    public String getIndustry() {
        return industry;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", occupation='" + occupation + '\'' +
                ", industry='" + industry + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", additionalphonenumber='" + additionalphonenumber + '\'' +
                ", emailaddress='" + emailaddress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", coverstartdate='" + coverstartdate + '\'' +
                ", title=" + title +
                ", gender=" + gender +
                ", dob=" + dob +
                ", maritalstatus=" + maritalstatus +
                ", firsttimebuyer=" + firsttimebuyer +
                '}';
    }

    public static class CustomerDetailsBuilder {
        private String firstname = "Bhawana";
        private String lastname = "Pant";
        private String occupation = "Computer Engineer";
        private String industry = "Insurance";
        private String phonenumber = "08998478869";
        private String additionalphonenumber = "07667898878";
        private String emailaddress = "no.one@esure.com";
        private String postcode = "TW18 4EZ";
        private LocalDate coverstartdate = LocalDate.now();
        private Title title = MRS;
        private Gender gender = FEMALE;
        private LocalDate dob = LocalDate.of(1985,04,13);
        private MaritalStatus maritalstatus = MARRIED;
        private boolean firsttimebuyer = true;


        public CustomerDetailsBuilder title(Title title){
            this.title = title;
            return this;
        }

        public CustomerDetailsBuilder gender(Gender gender){
            this.gender = gender;
            return this;
        }
        public CustomerDetailsBuilder maritalstatus(MaritalStatus maritalstatus){
            this.maritalstatus = maritalstatus;
            return this;
        }
        public CustomerDetailsBuilder firsttimebuyer(Boolean firsttimebuyer){
            this.firsttimebuyer = firsttimebuyer;
            return this;
        }
        public CustomerDetails build(){
            CustomerDetails customerDetails = new CustomerDetails(this);
            return customerDetails;
        }
    }
}