package com.example.demo.repository;

import com.example.demo.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByOrigin(String origin);
    List<Recipe> findByNameContainingIgnoreCase(String name);
    List<Recipe> findByNameContainingIgnoreCaseAndOrigin(String name, String origin);
}