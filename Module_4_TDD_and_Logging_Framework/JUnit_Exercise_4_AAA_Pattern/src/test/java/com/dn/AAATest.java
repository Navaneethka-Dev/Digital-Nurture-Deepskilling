package com.dn;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class AAATest {
    private int counter;
    @BeforeEach
    void setUp() { counter = 0; }
    @AfterEach
    void tearDown() { counter = 0; }
    @Test
    void testAAA() {
        // Arrange
        int expected = 5;
        // Act
        counter += 5;
        // Assert
        assertEquals(expected, counter);
    }
}
