package com.dn;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    private Country defaultCountry;
    
    private List<Country> countries = new ArrayList<>();

    public CountryController() {
        countries.add(new Country("US", "United States"));
        countries.add(new Country("UK", "United Kingdom"));
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        List<Country> all = new ArrayList<>(countries);
        all.add(defaultCountry);
        return all;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        if(code.equalsIgnoreCase(defaultCountry.getCode())) return defaultCountry;
        return countries.stream().filter(c -> c.getCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }
}
