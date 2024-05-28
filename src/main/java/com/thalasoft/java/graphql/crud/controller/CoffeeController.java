package com.thalasoft.java.graphql.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.thalasoft.java.graphql.crud.model.Coffee;
import com.thalasoft.java.graphql.crud.model.Size;
import com.thalasoft.java.graphql.crud.service.CoffeeService;


@Controller
public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @QueryMapping
    public List<Coffee> findAll() {
        return coffeeService.findAll();
    }

    @QueryMapping
    public Optional<Coffee> findOne(@Argument Integer id) {
        return coffeeService.findOne(id);
    }

    @MutationMapping
    public Coffee create(@Argument String name, @Argument Size size) {
        return coffeeService.create(name, size);
    }

    @MutationMapping
    public Coffee update(@Argument Integer id, @Argument String name, @Argument Size size) {
        return coffeeService.update(id, name, size);
    }

    @MutationMapping
    public Coffee delete(@Argument Integer id) {
        return coffeeService.delete(id);
    }
}
