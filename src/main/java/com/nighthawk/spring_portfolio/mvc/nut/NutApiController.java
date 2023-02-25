package com.nighthawk.spring_portfolio.mvc.nut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/nut") // all requests in file begin with this URI
public class NutApiController {

    // Autowired enables Control to connect URI request and POJO Object to easily
    // for Database CRUD operations
    @Autowired
    private NutJpaRepository repository;

    /*
     * GET List of Jokes
     * 
     * @GetMapping annotation is used for mapping HTTP GET requests onto specific
     * handler methods.
     */
    @GetMapping("/")
    public ResponseEntity<List<Nut>> getNut() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create/{food}/{calories}/{category}")
    public ResponseEntity<Nut> createNut(@PathVariable String food,
            @PathVariable double calories, @PathVariable String category) {
        repository.saveAndFlush(new Nut(null, food, calories, category));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search/{food}")
    public ResponseEntity<List<Nut>> searchNut(@PathVariable String food) {
        List<Nut> listings = repository.findByFoodIgnoreCase(food);
        return new ResponseEntity<>(listings,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Nut> deleteListing(@PathVariable long id) {
        Optional<Nut> optional = repository.findById(id);
        if (optional.isPresent()) { // Good ID
            Nut listing = optional.get(); // value from findByID
            repository.deleteById(id); // value from findByID
            return new ResponseEntity<>(listing, HttpStatus.OK); // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Nut> updateListing(@PathVariable long id, @RequestBody Nut newListing) {
        Optional<Nut> optional = repository.findById(id);
        if (optional.isPresent()) { // Good ID
            Nut listing = optional.get(); // value from findByID
            listing.setFood(newListing.getFood()); // value from findByID
            listing.setCalories(newListing.getCalories()); // value from findByID
            listing.setCategory(newListing.getCategory()); // value from findByID
            repository.save(listing);
            return new ResponseEntity<>(listing, HttpStatus.OK); // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}