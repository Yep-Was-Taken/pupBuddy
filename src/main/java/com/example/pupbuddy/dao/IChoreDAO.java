package com.example.pupbuddy.dao;

import com.example.pupbuddy.dto.Chore;

import java.util.HashMap;
import java.util.List;

public interface IChoreDAO {
    Chore save(Chore chore) throws Exception;

    List<Chore> fetchAll();

    Chore fetch(String id);

    void delete(String id);
}
