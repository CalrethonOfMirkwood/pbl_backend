package com.nighthawk.spring_portfolio.mvc.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/recipes") // all requests in file begin with this URI
public class RecipeController {

    // Autowired enables Control to connect URI request and POJO Object to easily
    // for Database CRUD operations
    @Autowired
    private RecipeJpaRepository repository;

    /*
     * GET List of Jokes
     * 
     * @GetMapping annotation is used for mapping HTTP GET requests onto specific
     * handler methods.
     */
    @GetMapping("/")
    public ResponseEntity<List<Recipe>> getJokes() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create/{name}/{price}/{seller}/{description}/{ingredients}")
    public ResponseEntity<Recipe> createJoke(@PathVariable String name, @PathVariable Integer price,
            @PathVariable String seller, @PathVariable String description, @PathVariable String ingredients) {
        repository.saveAndFlush(new Recipe(null, name, price, seller, description, ingredients));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Recipe>> searchJoke(@PathVariable String name) {
        List<Recipe> listings = repository.findByNameIgnoreCase(name);
        return new ResponseEntity<>(listings,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Recipe> deleteListing(@PathVariable long id) {
        Optional<Recipe> optional = repository.findById(id);
        if (optional.isPresent()) { // Good ID
            Recipe listing = optional.get(); // value from findByID
            repository.deleteById(id); // value from findByID
            return new ResponseEntity<>(listing, HttpStatus.OK); // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Recipe> updateListing(@PathVariable long id, @RequestBody Recipe newListing) {
        Optional<Recipe> optional = repository.findById(id);
        if (optional.isPresent()) { // Good ID
            Recipe listing = optional.get(); // value from findByID
            listing.setName(newListing.getName()); // value from findByID
            listing.setPrice(newListing.getPrice()); // value from findByID
            listing.setSeller(newListing.getSeller()); // value from findByID
            listing.setDescription(newListing.getDescription()); // value from findByID
            listing.setIngredients(newListing.getIngredients());
            repository.save(listing);
            return new ResponseEntity<>(listing, HttpStatus.OK); // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}