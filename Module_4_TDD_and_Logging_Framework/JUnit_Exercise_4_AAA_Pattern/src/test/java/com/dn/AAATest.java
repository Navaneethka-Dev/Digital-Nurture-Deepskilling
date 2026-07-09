package com.dn;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("AAA Pattern Validation")
public class AAATest {
    
    private int transactionCount;

    @BeforeEach
    void setupContext() { 
        transactionCount = 100;
    }

    @AfterEach
    void teardownContext() { 
        transactionCount = 0; 
    }

    @Test
    @DisplayName("Verify addition logic using AAA structure")
    void executeAAAPattern() {
        int amountToAdd = 50;
        int expectedResult = 150;
        
        transactionCount += amountToAdd;
        
        assertEquals(expectedResult, transactionCount, "Transaction count did not aggregate properly.");
    }
}
