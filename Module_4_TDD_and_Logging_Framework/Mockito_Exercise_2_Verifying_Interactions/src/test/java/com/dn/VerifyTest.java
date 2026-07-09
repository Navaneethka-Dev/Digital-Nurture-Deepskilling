package com.dn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

// Interface simulating an external email service
interface EmailService { 
    void sendEmail(String recipient, String body); 
}

/**
 * Demonstrates verifying interaction with mocked objects using Mockito.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Mockito Interaction Verification")
public class VerifyTest {
    
    @Mock
    EmailService emailServiceMock;

    @Test
    @DisplayName("Verify that the email service was invoked correctly")
    void validateServiceInteraction() {
        // Arrange
        String targetUser = "user@example.com";
        String emailContent = "Welcome to the Deep Skilling Program!";
        
        // Act
        emailServiceMock.sendEmail(targetUser, emailContent);
        
        // Assert
        // Verify that sendEmail was called exactly once with these exact parameters
        verify(emailServiceMock, times(1)).sendEmail(targetUser, emailContent);
    }
}
