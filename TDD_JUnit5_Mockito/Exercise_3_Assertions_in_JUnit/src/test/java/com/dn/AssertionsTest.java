package com.dn;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AssertionsTest {
    @Test
    void testAssertions() {
        assertEquals(4, 2 + 2);
        assertTrue(5 > 3);
        assertNotNull(new Object());
    }
}
