package com.nighthawk.spring_portfolio.mvc.nut;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// JPA is an object-relational mapping (ORM) to persistent data, originally relational databases (SQL). Today JPA implementations has been extended for NoSQL.
public interface NutJpaRepository extends JpaRepository<Nut, Long> {
    // JPA has many built in methods, these few have been prototyped for this
    // application
    List<Nut> findByFoodIgnoreCase(String food);
}