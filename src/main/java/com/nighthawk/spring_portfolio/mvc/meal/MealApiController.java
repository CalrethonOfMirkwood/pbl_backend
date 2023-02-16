package com.nighthawk.spring_portfolio.mvc.meal;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealApiController {

    private List<Meal> meals = new ArrayList<>();

    @PostMapping
    public Meal addMeal(@RequestBody Meal meal) {
        meals.add(meal);
        return meal;
    }

    @GetMapping
    public List<Meal> getMeals() {
        return meals;
    }

    @DeleteMapping("/{day}/{mealType}")
        public List<Meal> deleteMeal(@PathVariable String day, @PathVariable String mealType) {
        meals.removeIf(meal -> meal.getDay().equals(day) && meal.getMeal().equals(mealType));
        return meals;
}
}
