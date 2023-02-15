package com.nighthawk.spring_portfolio.mvc.nut;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// JPA is an object-relational mapping (ORM) to persistent data, originally relational databases (SQL). Today JPA implementations has been extended for NoSQL.
public interface NutJpaRepository extends JpaRepository<Nut, Long> {
    // JPA has many built in methods, these few have been prototyped for this
    // application
    void save(String food);

    // A
    List<Nut> findByFoodIgnoreCase(String food); // look to see if Joke(s) exist

    @Query(value = "SELECT * FROM Nut p WHERE p.food LIKE ?1 or p.category LIKE ?1", nativeQuery = true)
    List<Nut> findByFoodorCategory(String term);

    @Query(value = "SELECT max(id) FROM Nut")
    long getMaxId();
}