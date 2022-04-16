package com.example.pupbuddy.service;

import com.example.pupbuddy.dto.House;


import java.util.concurrent.ExecutionException;

public interface IHouseCRUDService {
    public String createHouse(House house) throws ExecutionException, InterruptedException;
    public House getHouse(String houseId) throws ExecutionException, InterruptedException;
    public String updateHouse(House house) throws ExecutionException, InterruptedException;
    public String deleteHouse(String houseId);
}
