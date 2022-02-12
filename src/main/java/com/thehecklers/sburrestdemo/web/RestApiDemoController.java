package com.thehecklers.sburrestdemo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thehecklers.sburrestdemo.domain.Coffee;

@RestController
@RequestMapping("/coffees")
public class RestApiDemoController {

    private final List<Coffee> coffees = new ArrayList<>();

    public RestApiDemoController() {
        this.coffees.addAll(List.of(
                new Coffee("Café Cereza"),
                new Coffee("Cappucino"),
                new Coffee("Latte Macchiato")
        ));
    }

    @GetMapping
    public Iterable<Coffee> getCoffees() {
        return coffees;
    }

    @GetMapping("/{id}")
    public Optional<Coffee> getCoffeeById(@PathVariable String id) {
        for (Coffee coffee : coffees) {
            if (coffee.getId().equals(id)) {
                return Optional.of(coffee);
            }
        }
        return Optional.empty();
    }

    @PostMapping
    public Coffee postCoffee(@RequestBody Coffee coffee) {
        Coffee aCoffee = new Coffee(coffee.getName());
        coffees.add(aCoffee);
        return aCoffee;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        int coffeeIndex = -1;

        for (Coffee aCoffee : coffees) {
            if (aCoffee.getId().equals(id)) {
                coffeeIndex = coffees.indexOf(aCoffee);
                aCoffee.setName(coffee.getName());
                coffees.set(coffeeIndex, aCoffee);
            }
        }

        return (coffeeIndex == -1) ?
                ResponseEntity.status(HttpStatus.CREATED).body(postCoffee(coffee)) :
                ResponseEntity.ok(coffees.get(coffeeIndex));
    }

    @DeleteMapping("/{id}")
    public void deleteCoffee(@PathVariable String id) {
        coffees.removeIf(coffee -> coffee.getId().equals(id));
    }
}
