package com.example.pupbuddy.dto;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Data;

public @Data class Dog {
    @DocumentId
    private String dogId;
    private String dogName;
    private String dogBreed;
    private int dogAge;
    private String houseId;
}
