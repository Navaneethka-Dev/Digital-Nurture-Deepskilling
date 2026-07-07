package com.dn;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    private Country defaultCountry; // Loaded from XML
    
    private List<Country> countries = new ArrayList<>();

    public CountryController() {
        countries.add(new Country("US", "United States"));
        countries.add(new Country("UK", "United Kingdom"));
    }

    // Hello World RESTful Web Service
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    // REST - Country Web Service (Get All)
    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        List<Country> all = new ArrayList<>(countries);
        all.add(defaultCountry);
        return all;
    }

    // REST - Get country based on country code
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        if(code.equalsIgnoreCase(defaultCountry.getCode())) return defaultCountry;
        return countries.stream().filter(c -> c.getCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }
}
