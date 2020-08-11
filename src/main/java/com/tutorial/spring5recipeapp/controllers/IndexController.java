package com.tutorial.spring5recipeapp.controllers;

import com.tutorial.spring5recipeapp.domain.Category;
import com.tutorial.spring5recipeapp.domain.UnitOfMeasure;
import com.tutorial.spring5recipeapp.repositories.CategoryRepository;
import com.tutorial.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {

        Optional<Category> optionalCategory = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByDescription("Ounce");

        System.out.println("It should be 1: " + optionalCategory.get().getId());
        System.out.println("It should be 5: " + optionalUnitOfMeasure.get().getId());
        return "index";
    }
}
