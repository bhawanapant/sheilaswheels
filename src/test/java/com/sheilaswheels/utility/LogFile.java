package com.sheilaswheels.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sheilaswheels.domain.InsuranceData;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * Created by bhawana on 12/05/2017.
 */
public class LogFile {
        private static ObjectMapper mapper;

        public static void getDetailsOfObjectUsedInLogFile(InsuranceData.YourDetails yourDetails) throws JsonProcessingException {
            mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            LOGGER.info(" The data for yourDetails is " + mapper.writeValueAsString(yourDetails));
        }

//        public static void getTheErrorMessageInDetail(String message) throws JsonProcessingException {
//            mapper = new ObjectMapper();
//            mapper.enable(SerializationFeature.INDENT_OUTPUT);
//            LOGGER.info(" Error Message Occur" + mapper.writeValueAsString(message));
//    }
}
