package com.thehecklers.sburrestdemo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thehecklers.sburrestdemo.config.Greeting;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final Greeting greeting;

    public GreetingController(Greeting greeting) {
        this.greeting = greeting;
    }

    @GetMapping
    public String getName() {
        return greeting.getName();
    }

    @GetMapping("/coffee")
    public String getNameAndCoffee() {
        return greeting.getCoffee();
    }
}
