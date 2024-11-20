package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Recipe;
import com.example.demo.service.RecipeService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public Optional<Recipe> getRecipeById(@PathVariable Long id) {
        return recipeService.getRecipeById(id);
    }

    @PostMapping
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }
}
