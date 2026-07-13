package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");
        
        countryService = context.getBean(CountryService.class);
        
        testGetAllCountries();
        getAllCountriesTest();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start testGetAllCountries");
        var countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End testGetAllCountries");
    }

    private static void getAllCountriesTest() {
        LOGGER.info("Start getAllCountriesTest (Find by code)");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("End getAllCountriesTest");
    }

    private static void testAddCountry() {
        LOGGER.info("Start testAddCountry");
        Country newCountry = new Country();
        newCountry.setCode("MM");
        newCountry.setName("My Custom Country");
        countryService.addCountry(newCountry);
        
        try {
            Country addedCountry = countryService.findCountryByCode("MM");
            LOGGER.debug("Added Country: {}", addedCountry);
        } catch (CountryNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("End testAddCountry");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start testUpdateCountry");
        try {
            countryService.updateCountry("MM", "Modified Country");
            Country updatedCountry = countryService.findCountryByCode("MM");
            LOGGER.debug("Updated Country: {}", updatedCountry);
        } catch (CountryNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("End testUpdateCountry");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start testDeleteCountry");
        countryService.deleteCountry("MM");
        try {
            countryService.findCountryByCode("MM");
        } catch (CountryNotFoundException e) {
            LOGGER.error("Expected exception: " + e.getMessage());
        }
        LOGGER.info("End testDeleteCountry");
    }
}
