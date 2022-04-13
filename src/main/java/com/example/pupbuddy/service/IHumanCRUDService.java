package com.example.pupbuddy.service;

import com.example.pupbuddy.dto.Human;

import java.util.concurrent.ExecutionException;

public interface IHumanCRUDService {
    public String createHuman(Human human) throws ExecutionException, InterruptedException;
    public Human getHuman(String humanId, String houseId) throws ExecutionException, InterruptedException;
    public String updateHuman(Human human) throws ExecutionException, InterruptedException;
    public String deleteHuman(String humanId, String houseId);
}
