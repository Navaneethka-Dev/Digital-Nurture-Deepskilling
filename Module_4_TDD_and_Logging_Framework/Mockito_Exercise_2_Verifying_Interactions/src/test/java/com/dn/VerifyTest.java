package com.dn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

interface EmailService { 
    void sendEmail(String recipient, String body); 
}

@ExtendWith(MockitoExtension.class)
@DisplayName("Mockito Interaction Verification")
public class VerifyTest {
    
    @Mock
    EmailService emailServiceMock;

    @Test
    @DisplayName("Verify that the email service was invoked correctly")
    void validateServiceInteraction() {
        String targetUser = "user@example.com";
        String emailContent = "Welcome to the Deep Skilling Program!";
        
        emailServiceMock.sendEmail(targetUser, emailContent);
        
        verify(emailServiceMock, times(1)).sendEmail(targetUser, emailContent);
    }
}
