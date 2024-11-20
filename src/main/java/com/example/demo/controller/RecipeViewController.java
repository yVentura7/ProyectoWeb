package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.RecipeService;

@Controller
public class RecipeViewController {

    @Autowired
    private RecipeService recipeService;


    
    @GetMapping("/recipes")
    public String listRecipes(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String origin,
            Model model) {

        model.addAttribute("recipes", recipeService.searchAndFilterRecipes(name, origin));

        // Cargar las opciones para el combobox
        model.addAttribute("origins", List.of(
                "Spanish", "Italian", "American", "French", "Indian",
                "Thai", "Russian", "Argentinian", "Japanese", "Peruvian",
                "Turkish", "Mexican", "Venezuelan", "British"
        ));

        // Pasar los valores actuales del buscador y filtro para mantenerlos en el formulario
        model.addAttribute("selectedName", name);
        model.addAttribute("selectedOrigin", origin);

        return "list";
    }

    @GetMapping("/recipes/{id}")
    public String recipeDetails(@PathVariable Long id, Model model) {
        model.addAttribute("recipe", recipeService.getRecipeById(id).orElse(null));
        return "details";
    }
    
}
