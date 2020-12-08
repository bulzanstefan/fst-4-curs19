package ro.fasttrackit.curs19.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs19.exceptions.ResourceNotFoundException;
import ro.fasttrackit.curs19.model.Country;
import ro.fasttrackit.curs19.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService service) {
        this.countryService = service;
    }

    @GetMapping
    List<Country> getCountries(@RequestParam(required = false) String continent) {
        return countryService.getCountries(continent);
    }

    @GetMapping("{countryId}")
    Country getCountry(@PathVariable int countryId) {
        return countryService.getCountry(countryId)
                .orElseThrow(() -> new ResourceNotFoundException("Country with id " + countryId
                        + " does not exist"));
    }

    @PostMapping
    Country addNewCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PutMapping("{countryId}")
    Country replaceCountry(@PathVariable int countryId, @RequestBody Country country) {
        return countryService.replaceCountry(countryId, country);
    }

    @PatchMapping("{countryId}")
    Country updateCountry(@PathVariable int countryId, @RequestBody Country country) {
        return countryService.updateCountry(countryId, country);
    }

    @DeleteMapping("{countryId}")
    Country deleteCountry(@PathVariable int countryId){
        return countryService.deleteCountry(countryId);
    }

}
