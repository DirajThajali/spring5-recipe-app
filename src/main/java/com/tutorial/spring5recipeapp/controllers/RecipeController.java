package com.tutorial.spring5recipeapp.controllers;

import com.tutorial.spring5recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/recipe", "/recipe.html"})
    public String listRecipes(Model model) {
        log.debug("getting recipe page");
        log.debug("logger from Recipe Controller ######################################################");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "recipe/list";
    }
}
