package com.example.pupbuddy.dao;

import com.example.pupbuddy.dto.Chore;
import com.example.pupbuddy.dto.Dog;
import com.example.pupbuddy.dto.House;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HouseDAOStub implements IHouseDAO{
    private ArrayList<House> allHouses = new ArrayList<>();

    @Override
    public House save(House house) throws IOException {
        allHouses.add(house);
        return house;
    }

    @Override
    public List<House> fetchAll() {
        return allHouses;
    }

    @Override
    public House fetch(String id) {
        for (House house : allHouses) {
            if (house.getHouseId().equals(id)) {
                return house;
            }
        }
        return null;
    }

    @Override
    public void delete(String id) {
        allHouses.remove(id);
    }
}
