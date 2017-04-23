package com.esure.sheilas.wheels.domain;


import com.esure.sheilas.wheels.domain.enumType.*;
import lombok.Builder;

import static com.esure.sheilas.wheels.domain.enumType.AccessToAnyVehicle.NO;
import static com.esure.sheilas.wheels.domain.enumType.CarInHousehold.TWO;
import static com.esure.sheilas.wheels.domain.enumType.ExpDrivingAnotherVehicle.NONE;
import static com.esure.sheilas.wheels.domain.enumType.LicenceHeld.YESACCESSTO;
import static com.esure.sheilas.wheels.domain.enumType.LicenceType.FULLUKLICENCE;
import static com.esure.sheilas.wheels.domain.enumType.NCDYear.ONEYEAR;
import static com.esure.sheilas.wheels.domain.enumType.NoOfChildrenAtAddress.ONE;
import static com.esure.sheilas.wheels.domain.enumType.ResidentialStatus.HOMEOWNER;
import static com.esure.sheilas.wheels.domain.enumType.YearOfClaimFreeOnVehicle.UNDERONEYEAR;

@Builder
public class AboutYou {
    private boolean ukresident;
    private boolean secondoccupation;
    private NoOfChildrenAtAddress childrenatAddress;
    private ResidentialStatus residentialstatus;
    private CarInHousehold carinhousehold;
    private AccessToAnyVehicle accesofvehicle;
    private LicenceType licencetype;
    private LicenceHeld licenceheld;
    private NCDYear ncdyear;
    private ExpDrivingAnotherVehicle expDrivingAnothervehicle;
    private YearOfClaimFreeOnVehicle yearofclaimfreeOnvehicle;
    private String registrationno;
    private String postcode;

    public static class AboutYouBuilder {
        private boolean ukresident = true;
        private boolean secondoccupation = false;
        private NoOfChildrenAtAddress childrenataddress = ONE;
        private ResidentialStatus residentialstatus = HOMEOWNER;
        private CarInHousehold carinhousehold = TWO;
        private AccessToAnyVehicle accesofvehicle = NO;
        private LicenceType licencetype = FULLUKLICENCE;
        private LicenceHeld licenceheld = YESACCESSTO;
        private NCDYear ncdyear = ONEYEAR;
        private ExpDrivingAnotherVehicle expDrivingAnothervehicle = NONE;
        private YearOfClaimFreeOnVehicle yearofclaimfreeOnvehicle = UNDERONEYEAR;
        private String registrationno = "BL64 PK0";
        private String postcode = "TW18 4EZ";
    }

}
