package com.example.pupbuddy.service;

import com.example.pupbuddy.dto.Chore;

import java.util.concurrent.ExecutionException;

public interface IChoreCRUDService {
    public String createChore(Chore chore) throws ExecutionException, InterruptedException;
    public Chore getChore(String choreId, String houseId) throws ExecutionException, InterruptedException;
    public String updateChore(Chore chore) throws ExecutionException, InterruptedException;
    public String deleteChore(String choreId, String houseId);
}
