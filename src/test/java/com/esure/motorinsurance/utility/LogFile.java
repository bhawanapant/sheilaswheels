package com.esure.motorinsurance.utility;

import com.esure.motorinsurance.stepdefs.GetPolicyStepDefinitions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.esure.motorinsurance.domain.InsuranceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bhawana on 12/05/2017.
 */
public class LogFile {
    private static ObjectMapper mapper;
    private static Logger LOGGER = LoggerFactory.getLogger(GetPolicyStepDefinitions.class);


    public static void getDetailsOfObjectUsedInLogFile(InsuranceData insuranceData, String message) throws JsonProcessingException {
            mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            LOGGER.info("Final Quote Details for Motor Insurance" +
                " is "  + mapper.writeValueAsString(insuranceData));
            LOGGER.info(message);

        }
}
