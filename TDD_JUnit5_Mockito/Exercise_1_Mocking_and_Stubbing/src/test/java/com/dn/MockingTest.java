package com.dn;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

interface DataService { String getData(); }

@ExtendWith(MockitoExtension.class)
public class MockingTest {
    @Mock
    DataService dataService;

    @Test
    void testMocking() {
        when(dataService.getData()).thenReturn("Mocked Data");
        assertEquals("Mocked Data", dataService.getData());
    }
}
