package com.lti.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

class TestAssumptions {
//Additional support while executing
//a failed Assumptions results in Test being terminated when 
// when to use - if test case failed ..do not continue 
	
	@Test
    void testOnDev()
    {
        System.setProperty("ENV", "DEV");
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")), TestAssumptions::message);
        System.out.println(" continue execution");
    }

    @Test
    void testOnProd()
    {
        System.setProperty("ENV", "PROD");
        Assumptions.assumeFalse("PROD".equals(System.getProperty("ENV")),TestAssumptions::message);
        System.out.println(" don't continue execution");
    }

    private static String message () {
        return "TEST Execution Failed :: ";
    }

}
