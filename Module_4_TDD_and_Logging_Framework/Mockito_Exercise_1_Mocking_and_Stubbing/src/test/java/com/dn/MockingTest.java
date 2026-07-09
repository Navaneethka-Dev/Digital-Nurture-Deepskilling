package com.dn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

interface PaymentGateway { 
    String processTransaction(double amount); 
}

@ExtendWith(MockitoExtension.class)
@DisplayName("Mockito Mocking & Stubbing")
public class MockingTest {
    
    @Mock
    PaymentGateway paymentGatewayMock;

    @Test
    @DisplayName("Stubbing a method call on PaymentGateway")
    void validateMockStubbing() {
        double transactionAmount = 99.99;
        String successMessage = "TXN_APPROVED";
        when(paymentGatewayMock.processTransaction(transactionAmount)).thenReturn(successMessage);
        
        String actualResult = paymentGatewayMock.processTransaction(transactionAmount);
        
        assertEquals(successMessage, actualResult, "The mocked service should return the stubbed success message.");
    }
}
