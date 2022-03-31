package com.example.pupbuddy.service;

import com.example.pupbuddy.dto.Dog;

import java.util.List;

public interface IDogService {

    Dog fetchById(String id);

    void delete(String id) throws Exception;

    Dog save(Dog dog) throws Exception;

    List<Dog> fetchAll();
}
