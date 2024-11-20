package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Recipe;
import com.example.demo.repository.RecipeRepository;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getRecipesByOrigin(String origin) {
        return recipeRepository.findByOrigin(origin);
    }

    public List<Recipe> searchRecipesByName(String name) {
        return recipeRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Recipe> searchAndFilterRecipes(String name, String origin) {
        if (name != null && !name.isEmpty() && origin != null && !origin.isEmpty()) {
            return recipeRepository.findByNameContainingIgnoreCaseAndOrigin(name, origin);
        } else if (name != null && !name.isEmpty()) {
            return recipeRepository.findByNameContainingIgnoreCase(name);
        } else if (origin != null && !origin.isEmpty()) {
            return recipeRepository.findByOrigin(origin);
        } else {
            return getAllRecipes();
        }
    }
}