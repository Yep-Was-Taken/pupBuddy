package com.example.pupbuddy.dto;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public @Data class House {
    @DocumentId
    private String houseId;
    private Map<String, Human> humans = new HashMap<>();
    private Map<String, Dog> dogs = new HashMap<>();
    private Map<String, Chore> chores = new HashMap<>();
}
