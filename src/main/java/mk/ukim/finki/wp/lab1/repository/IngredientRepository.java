package mk.ukim.finki.wp.lab1.repository;

import mk.ukim.finki.wp.lab1.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends PagingAndSortingRepository<Ingredient, Long>, JpaRepository<Ingredient,Long>{
}
