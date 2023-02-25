package com.nighthawk.spring_portfolio.controllers;
import org.springframework.web.bind.annotation.GetMapping;

public class Planner {
        // CONTROLLER handles GET request for /birds, maps it to birds() method
        @GetMapping("/planner")
        public String planner() {
    
            // load HTML VIEW (birds.html)
            return "planner";
    
        }
}
