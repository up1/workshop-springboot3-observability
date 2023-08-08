package com.example.observability;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class HelloRepositoryTest {

    @Autowired
    private HelloRepository repository;

    @Test
    public void case01() {
        // Arrange
        repository.save(new Hello(1));
        // Act
        Optional<Hello> result = repository.findById(1);
        assertTrue(result.isPresent());
    }

}