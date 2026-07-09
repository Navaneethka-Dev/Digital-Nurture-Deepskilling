package com.dn;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Demonstrates the Arrange-Act-Assert (AAA) testing pattern.
 */
@DisplayName("AAA Pattern Validation")
public class AAATest {
    
    private int transactionCount;

    @BeforeEach
    void setupContext() { 
        transactionCount = 100; // Starting baseline
    }

    @AfterEach
    void teardownContext() { 
        transactionCount = 0; 
    }

    @Test
    @DisplayName("Verify addition logic using AAA structure")
    void executeAAAPattern() {
        // ----------------- ARRANGE -----------------
        int amountToAdd = 50;
        int expectedResult = 150;
        
        // ----------------- ACT -----------------
        transactionCount += amountToAdd;
        
        // ----------------- ASSERT -----------------
        assertEquals(expectedResult, transactionCount, "Transaction count did not aggregate properly.");
    }
}
