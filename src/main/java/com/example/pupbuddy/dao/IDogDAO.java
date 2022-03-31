package com.example.pupbuddy.dao;

import com.example.pupbuddy.dto.Dog;

import java.util.List;

public interface IDogDAO {
    Dog save(Dog dog) throws Exception;

    List<Dog> fetchAll();

    Dog fetch(String id);

    void delete(String id);
}
