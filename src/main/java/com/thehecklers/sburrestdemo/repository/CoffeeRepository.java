package com.thehecklers.sburrestdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.thehecklers.sburrestdemo.domain.Coffee;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {
}