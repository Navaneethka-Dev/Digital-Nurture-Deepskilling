package com.dn;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

interface NotificationService { void sendNotification(); }

@ExtendWith(MockitoExtension.class)
public class VerifyTest {
    @Mock
    NotificationService notificationService;

    @Test
    void testVerify() {
        notificationService.sendNotification();
        verify(notificationService).sendNotification();
    }
}
