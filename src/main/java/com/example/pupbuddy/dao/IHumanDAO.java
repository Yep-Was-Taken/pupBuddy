package com.example.pupbuddy.dao;

import com.example.pupbuddy.dto.Human;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHumanDAO {
    Human save(Human human) throws Exception;

    List<Human> fetchAll();

    Human fetch(String id);

    void delete(String id);
}
