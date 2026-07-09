package com.dn;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisplayName("JUnit 5 Environment Setup Tests")
public class SetupTest {
    
    private static final Logger log = LoggerFactory.getLogger(SetupTest.class);

    @BeforeAll
    static void initAll() {
        log.info("Initializing global test environment...");
    }

    @Test
    @DisplayName("Verify Test Execution Pipeline")
    void testFrameworkInitialization() {
        log.info("Executing testFrameworkInitialization...");
        System.out.println("✅ JUnit 5 framework is fully operational and tests are running successfully.");
    }
    
    @AfterAll
    static void tearDownAll() {
        log.info("Tearing down global test environment...");
    }
}
