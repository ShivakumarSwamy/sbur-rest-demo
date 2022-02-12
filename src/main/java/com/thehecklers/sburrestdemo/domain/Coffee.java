package com.thehecklers.sburrestdemo.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Coffee {

    @Id
    @Column(nullable = false)
    private String id;
    private String name;


    public Coffee(String name) {
        this(UUID.randomUUID().toString(), name);
    }

}
