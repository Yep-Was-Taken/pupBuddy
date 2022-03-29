package com.example.pupbuddy.dao;

import com.example.pupbuddy.dto.Chore;
import com.example.pupbuddy.dto.Human;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HumanDAOStub implements IHumanDAO{
    private ArrayList<Human> allHumans = new ArrayList<>();

    @Override
    public Human save(Human human) throws Exception {
        allHumans.add(human);
        return human;
    }

    @Override
    public List<Human> fetchAll() {
        return allHumans;
    }

    @Override
    public Human fetch(String id) {
        for (Human human : allHumans) {
            if (human.getHumanId().equals(id)) {
                return human;
            }
        }
        return null;
    }

    @Override
    public void delete(String id) {
        allHumans.remove(id);
    }
}
