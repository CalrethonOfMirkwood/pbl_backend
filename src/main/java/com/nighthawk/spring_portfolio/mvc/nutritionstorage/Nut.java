package com.nighthawk.spring_portfolio.mvc.nutritionstorage;

//import java.util.ArrayList;

import javax.persistence.*;

@Entity // Annotation to simplify creating an entity, which is a lightweight persistence
        // domain object. Typically, an entity represents a table in a relational
        // database, and each entity instance corresponds to a row in that table.
public class Nut {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String food;

    @Column
    private double calories;

    @Column
    private String category;

    private Nut() {
    }

    protected Nut(Long id, String food, double calories, String category) {
        if (food == null)
            throw new NullPointerException("food");
        this.calories = calories;
        this.category = category;
        System.out.println(food);
        this.food = food;
    }

    public String getFood() {
        return this.food;
    }

    public double getCalories() {
        return this.calories;
    }

    public String getCategory() {
        return this.category;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    /// Tester Method ToString
    public String toString() {
        return ("{ \"food\": " + this.food + ", " + "\"calories\": " + this.calories + ", " + "\"category\": " + this.category + "}");
    }

    public static void main(String[] args) {
        Nut newFood = new Nut();
        newFood.setFood("Potato");
        newFood.setCalories(110);
        newFood.setCategory("raw");

        System.out.println(newFood.toString());
    }
}





