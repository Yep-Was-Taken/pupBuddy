package com.example.pupbuddy.service;

import com.example.pupbuddy.dto.Chore;

import java.util.List;

public interface IChoreService {

    Chore fetchById(String id);

    void delete(String id) throws Exception;

    Chore save(Chore chore) throws Exception;

    List<Chore> fetchAll();
}
