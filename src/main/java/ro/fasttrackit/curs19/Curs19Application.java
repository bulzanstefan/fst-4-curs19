package ro.fasttrackit.curs19;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs19.service.CountryReader;

@SpringBootApplication
public class Curs19Application {

    public static void main(String[] args) {
        SpringApplication.run(Curs19Application.class, args);
    }

}
