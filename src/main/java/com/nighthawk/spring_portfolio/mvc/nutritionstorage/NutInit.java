package com.nighthawk.spring_portfolio.mvc.nutritionstorage;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component // Scans Application for ModelInit Bean, this detects CommandLineRunner
public class NutInit {

    // Inject repositories
    @Autowired
    NutJpaRepository repository;

    @Bean
    CommandLineRunner runNut() { // The run() method will be executed after the application starts
        return args -> {
            // Fail safe data validation
            // starting jokes
            final String[] foodArray = {
                    "apple", "120", "raw",

            };

            // make sure Joke database is populated with starting jokes

            for (String food : foodArray) {
                List<Nut> test = repository.findByFoodIgnoreCase(food); // JPA lookup
                if (test.size() == 0)
                    repository.save(new Nut(null, food, 120, "raw")); // JPA save
            }

        };
    }
}