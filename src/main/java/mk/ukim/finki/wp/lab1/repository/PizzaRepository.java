package mk.ukim.finki.wp.lab1.repository;

import mk.ukim.finki.wp.lab1.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza,Long> {
}
