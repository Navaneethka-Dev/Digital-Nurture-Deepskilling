package com.dn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Demonstrates the usage of various assertions available in JUnit 5.
 */
@DisplayName("JUnit 5 Assertions Demonstration")
public class AssertionsTest {

    @Test
    @DisplayName("Test basic arithmetic operations using assertEquals")
    void validateArithmetic() {
        assertEquals(25, 5 * 5, "Multiplication should yield exact expected value.");
    }

    @Test
    @DisplayName("Test logical conditions using assertTrue and assertFalse")
    void validateLogicalConditions() {
        assertTrue(100 > 50, "100 must be greater than 50");
        assertFalse("OpenAI".isEmpty(), "String should not be empty");
    }

    @Test
    @DisplayName("Test object references using assertNull and assertNotNull")
    void validateObjectReferences() {
        Object systemEntity = new Object();
        assertNotNull(systemEntity, "Newly created object should never be null");
        
        String emptyReference = null;
        assertNull(emptyReference, "Uninitialized reference should be null");
    }
    
    @Test
    @DisplayName("Test collections using assertIterableEquals")
    void validateCollections() {
        List<String> actualList = Arrays.asList("Alpha", "Beta", "Gamma");
        List<String> expectedList = Arrays.asList("Alpha", "Beta", "Gamma");
        assertIterableEquals(expectedList, actualList, "Both lists must contain identical elements in order.");
    }
}
