package com.example.pupbuddy.dto;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Data;

public @Data class Human {
    @DocumentId
    private String humanId;
    private String humanName;
    private String careRole;
    private String houseId;
}
