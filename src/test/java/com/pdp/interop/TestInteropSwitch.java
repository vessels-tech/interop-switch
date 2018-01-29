package com.pdp.interop;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.tck.junit4.FunctionalTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public class TestInteropSwitch extends FunctionalTestCase {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected String getConfigResources() {
        return "test-resources.xml,interop-switch-main.xml,interop-switch.xml";
    }

    @BeforeClass
    public static void initEnv() {
        System.setProperty("MULE_ENV", "test");
    }

    @Test
    @Ignore
    public void testTransfer() throws Exception {
        String transferRequest = loadResourceAsString("data/TransferRequest.json");

        given().
            contentType("application/json").
            body(transferRequest).
        when().
            post("http://localhost:8088/switch/v1/transfers").
        then().
            statusCode(202);
    }

}
