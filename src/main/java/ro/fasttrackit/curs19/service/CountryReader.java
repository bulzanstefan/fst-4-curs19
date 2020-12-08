package ro.fasttrackit.curs19.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs19.model.Country;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

@Service
public class CountryReader {
    private int nextId = 1;

    public List<Country> fetchCountries() {
        try {
            return new BufferedReader(new FileReader("countries.txt"))
                    .lines()
                    .map(this::parseCountry)
                    .collect(toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Country parseCountry(String line) {
        Scanner scanner = new Scanner(line).useDelimiter("\\|");
        return new Country(
                nextId++,
                scanner.next(),
                scanner.next(),
                scanner.nextLong(),
                scanner.nextDouble(),
                scanner.next(),
                scanner.hasNext() ? parseNeighbours(scanner.next()) : List.of()
        );
    }

    private List<String> parseNeighbours(String neighbours) {
        List<String> result = new ArrayList<>();
        Scanner scanner = new Scanner(neighbours).useDelimiter("~");
        while (scanner.hasNext()) {
            result.add(scanner.next());
        }
        return result;
    }
}
