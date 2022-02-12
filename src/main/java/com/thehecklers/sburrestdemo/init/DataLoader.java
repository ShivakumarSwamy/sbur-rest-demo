package com.thehecklers.sburrestdemo.init;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.thehecklers.sburrestdemo.domain.Coffee;
import com.thehecklers.sburrestdemo.repository.CoffeeRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataLoader {

    private final CoffeeRepository coffeeRepository;

    public DataLoader(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    private void loadData() {
        this.coffeeRepository.saveAll(List.of(
                new Coffee("Café Cereza"),
                new Coffee("Cappucino"),
                new Coffee("Latte Macchiato")
        ));
        log.info("Initial Data Loaded to Coffee Repository");
    }
}
