package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    public Country getCountry(String code) throws CountryNotFoundException {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countryList = context.getBean("countryList", ArrayList.class);
        
        Optional<Country> matchedCountry = countryList.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst();

        if (matchedCountry.isEmpty()) {
            throw new CountryNotFoundException();
        }

        LOGGER.info("END");
        return matchedCountry.get();
    }

    public void addCountry(Country country) {
        LOGGER.info("START addCountry");
        
        
        LOGGER.debug("Country added: {}", country);
        LOGGER.info("END addCountry");
    }

    public void updateCountry(String code, Country country) throws CountryNotFoundException {
        LOGGER.info("START updateCountry");
        
        getCountry(code); 
        LOGGER.debug("Country updated: {}", country);
        LOGGER.info("END updateCountry");
    }

    public void deleteCountry(String code) throws CountryNotFoundException {
        LOGGER.info("START deleteCountry");
        
        getCountry(code);
        LOGGER.debug("Country deleted with code: {}", code);
        LOGGER.info("END deleteCountry");
    }
}
