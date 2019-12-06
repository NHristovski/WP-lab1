package mk.ukim.finki.wp.lab1.service;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.lab1.model.Ingredient;
import mk.ukim.finki.wp.lab1.repository.IngredientRepository;
import mk.ukim.finki.wp.lab1.service.exceptions.DuplicateIngredientException;
import mk.ukim.finki.wp.lab1.service.exceptions.IngredientNotFoundException;
import mk.ukim.finki.wp.lab1.service.exceptions.SpicyIngredientsLimitReachedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.net.ServerSocket;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository repository;

    @Override
    public Ingredient add(Ingredient ingredient) throws SpicyIngredientsLimitReachedException,DuplicateIngredientException {
        if (getAllSpicy().size() == 3 && ingredient.isSpicy()){
            throw new SpicyIngredientsLimitReachedException("Cannot add fourth spicy ingredient");
        }

        try {
            return repository.save(ingredient);
        }catch (Exception ex){
            throw new DuplicateIngredientException("Ingredient with that name already exists");
        }
    }

    @Override
    public Ingredient edit(Ingredient ingredient) throws SpicyIngredientsLimitReachedException, DuplicateIngredientException, IngredientNotFoundException {
        Ingredient old = this.getOne(ingredient.getId());
        if (old == null){
            throw new IngredientNotFoundException("Ingredient not found");
        }
        if (!old.isSpicy() && ingredient.isSpicy() && getAllSpicy().size() == 3){
            throw new SpicyIngredientsLimitReachedException("Cannot add fourth spicy ingredient");
        }
        try {
            return repository.save(ingredient);
        }catch (Exception ex){
            throw new DuplicateIngredientException("Ingredient with that name already exists");
        }
    }

    @Override
    public Ingredient delete(Long id) {
        Ingredient ingredient = repository.getOne(id);
        repository.delete(ingredient);
        return ingredient;
    }

    @Override
    public Ingredient getOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<Ingredient> getAll(int currentPage, int pageSize) {
        Pageable page = PageRequest.of(currentPage, pageSize, Sort.by("name"));
        Page<Ingredient> all = repository.findAll(page);
        System.out.println("page: " + all + " content: " + all.getContent());
        System.out.println("all from repo: " + repository.findAll());
        return all.getContent();
    }

    @Override
    public List<Ingredient> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Ingredient>  getAllSpicy() {
        return repository.findAll().stream().filter(Ingredient::isSpicy).collect(Collectors.toList());
    }
}
