package com.example.pupbuddy.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Documentation: Include it here.
 * @author
 */


@Data
public class House {
    private int houseId;
    private Map<Integer, Human> humans = new HashMap<>();
    private Map<Integer, Dog> dogs = new HashMap<>();
    private Map<Integer, Chore> chores = new HashMap<>();
}
