package com.dn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

// External dependency interface
interface PaymentGateway { 
    String processTransaction(double amount); 
}

/**
 * Demonstrates mocking and stubbing behavior using Mockito.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Mockito Mocking & Stubbing")
public class MockingTest {
    
    @Mock
    PaymentGateway paymentGatewayMock;

    @Test
    @DisplayName("Stubbing a method call on PaymentGateway")
    void validateMockStubbing() {
        // Arrange: configure the mock
        double transactionAmount = 99.99;
        String successMessage = "TXN_APPROVED";
        when(paymentGatewayMock.processTransaction(transactionAmount)).thenReturn(successMessage);
        
        // Act: invoke the mocked behavior
        String actualResult = paymentGatewayMock.processTransaction(transactionAmount);
        
        // Assert: ensure it returned the stubbed data
        assertEquals(successMessage, actualResult, "The mocked service should return the stubbed success message.");
    }
}
