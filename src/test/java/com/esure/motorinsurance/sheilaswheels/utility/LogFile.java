package com.esure.motorinsurance.sheilaswheels.utility;

import com.esure.motorinsurance.sheilaswheels.stepdefs.GetPolicyStepDefinitions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.esure.motorinsurance.sheilaswheels.domain.InsuranceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bhawana on 12/05/2017.
 */
public class LogFile {
    private static ObjectMapper mapper;
    private static Logger LOGGER = LoggerFactory.getLogger(GetPolicyStepDefinitions.class);


    public static void getDetailsOfObjectUsedInLogFile(InsuranceData.YourDetails insuranceData) throws JsonProcessingException {
            mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            LOGGER.debug(" The data for Motor Insurance" +
                " is " + mapper.writeValueAsString(insuranceData));
        }
}
