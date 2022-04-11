package com.example.pupbuddy.service;

import com.example.pupbuddy.dto.Dog;

import java.util.concurrent.ExecutionException;

public interface IDogCRUDService {
    public String createDog(Dog dog) throws ExecutionException, InterruptedException;
    public Dog getDog(String dogId) throws ExecutionException, InterruptedException;
    public String updateDog(Dog dog) throws ExecutionException, InterruptedException;
    public String deleteDog(String dogId);
}
