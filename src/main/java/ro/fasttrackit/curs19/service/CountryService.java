package ro.fasttrackit.curs19.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs19.exceptions.ResourceNotFoundException;
import ro.fasttrackit.curs19.model.Country;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Service
public class CountryService {
    private final List<Country> countries;

    public CountryService(CountryReader reader) {
        this.countries = reader.fetchCountries();
    }

    public List<Country> getCountries(String continent) {
        if (continent == null) {
            return countries;
        } else {
            return getCountriesForContinent(continent);
        }
    }

    private List<Country> getCountriesForContinent(String continent) {
        return countries.stream()
                .filter(country -> country.getContinent().equalsIgnoreCase(continent))
                .collect(toList());
    }

    public Optional<Country> getCountry(int countryId) {
        return countries.stream()
                .filter(country -> country.getId() == countryId)
                .findFirst();
    }

    public Map<String, List<Country>> mapContinentToCountries() {
        return countries.stream()
                .collect(groupingBy(Country::getContinent));
    }

    public Country addCountry(Country country) {
        country.setId(calculateId());
        countries.add(country);
        return country;
    }

    private int calculateId() {
        return countries.stream()
                .mapToInt(Country::getId)
                .max()
                .orElse(0) + 1;
    }

    public Country replaceCountry(int countryId, Country country) {
        country.setId(countryId);
        deleteCountry(countryId);
        addCountry(country);
        return country;
    }

    public Country deleteCountry(int countryId) {
        Country country = getOrThrow(countryId);
        countries.remove(country);
        return country;
    }

    public Country updateCountry(int countryId, Country newCountry) {
        Country oldCountry = getOrThrow(countryId);
        String name = oldCountry.getName();
        String capital = oldCountry.getCapital();
        long population = oldCountry.getPopulation();

        if (newCountry.getName() != null) {
            name = newCountry.getName();
        }
        if (newCountry.getCapital() != null) {
            capital = newCountry.getCapital();
        }
        if (newCountry.getPopulation() != 0) {
            population = newCountry.getPopulation();
        }

        return replaceCountry(countryId,
                new Country(oldCountry.getId(),
                        name,
                        capital,
                        population,
                        oldCountry.getArea(),
                        oldCountry.getContinent(),
                        oldCountry.getNeighours()));
    }

    private Country getOrThrow(int countryId) {
        return getCountry(countryId)
                .orElseThrow(() -> new ResourceNotFoundException("Country with id " + countryId + " does not exist"));
    }
}
