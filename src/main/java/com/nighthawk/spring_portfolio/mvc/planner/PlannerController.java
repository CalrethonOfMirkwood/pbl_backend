package com.nighthawk.spring_portfolio.mvc.planner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/planner") // all requests in file begin with this URI
public class PlannerController {

    // Autowired enables Control to connect URI request and POJO Object to easily
    // for Database CRUD operations
    @Autowired
    private PlannerJpaRepository repository;

    /*
     * GET List of Jokes
     * 
     * @GetMapping annotation is used for mapping HTTP GET requests onto specific
     * handler methods.
     */
    @GetMapping("/")
    public ResponseEntity<List<Planner>> getPlanner() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create/{name}/{day}/{meal}")
    public ResponseEntity<Planner> createPlanner(@PathVariable String name,
            @PathVariable String day, @PathVariable String meal) {
        repository.saveAndFlush(new Planner(null, name, day, meal));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Planner>> searchPlanner(@PathVariable String name) {
        List<Planner> listings = repository.findByNameIgnoreCase(name);
        return new ResponseEntity<>(listings,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Planner> deleteListing(@PathVariable long id) {
        System.out.println("planner delete checkpoint 1.  id is "+id);
        Optional<Planner> optional = repository.findById(id);
        System.out.println("planner delete checkpoint 2");
        if (optional.isPresent()) { // Good ID
            System.out.println("planner delete checkpoint 3");
            Planner listing = optional.get(); // value from findByID
            System.out.println("planner delete checkpoint 4");
            repository.deleteById(id); // value from findByID
            System.out.println("planner delete checkpoint 5");
            return new ResponseEntity<>(listing, HttpStatus.OK); // OK HTTP response: status code, headers, and body
        }
        System.out.println("planner delete checkpoint 6.  Bad request.");
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Planner> updateListing(@PathVariable long id, @RequestBody Planner newListing) {
        Optional<Planner> optional = repository.findById(id);
        if (optional.isPresent()) { // Good ID
            Planner listing = optional.get(); // value from findByID
            listing.setName(newListing.getName()); // value from findByID
            listing.setDay(newListing.getDay()); // value from findByID
            listing.setMeal(newListing.getMeal()); // value from findByID
            repository.save(listing);
            return new ResponseEntity<>(listing, HttpStatus.OK); // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
