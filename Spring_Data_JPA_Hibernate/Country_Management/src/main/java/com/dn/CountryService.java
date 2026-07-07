package com.dn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepository repository;

    public Country addCountry(Country country) {
        return repository.save(country);
    }

    public Optional<Country> findCountryByCode(String code) {
        return repository.findById(code);
    }
}
