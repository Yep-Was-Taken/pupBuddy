package com.example.pupbuddy.service;

import com.example.pupbuddy.dto.Human;

import java.util.List;

public interface IHumanService {

    Human fetchById(String id);

    void delete(String id) throws Exception;

    Human save(Human human) throws Exception;

    List<Human> fetchAll();
}
