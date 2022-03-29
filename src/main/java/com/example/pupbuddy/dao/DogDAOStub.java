package com.example.pupbuddy.dao;

import com.example.pupbuddy.dto.Chore;
import com.example.pupbuddy.dto.Dog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DogDAOStub implements IDogDAO{
    private ArrayList<Dog> allDogs = new ArrayList<>();

    @Override
    public Dog save(Dog dog) throws Exception {
        allDogs.add(dog);
        return dog;
    }

    @Override
    public List<Dog> fetchAll() {
        return allDogs;
    }

    @Override
    public Dog fetch(String id) {
        for (Dog dog : allDogs) {
            if (dog.getDogId().equals(id)) {
                return dog;
            }
        }
        return null;
    }

    @Override
    public void delete(String id) {
        allDogs.remove(id);
    }
}
