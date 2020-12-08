package ro.fasttrackit.curs19.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.curs19.model.Country;
import ro.fasttrackit.curs19.service.CountryService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("continents")
public class ContinentController {
    private final CountryService service;

    public ContinentController(CountryService service) {
        this.service = service;
    }

    @GetMapping("countries")
    Map<String, List<Country>> mapContinentToCountries() {
        return service.mapContinentToCountries();
    }
}
