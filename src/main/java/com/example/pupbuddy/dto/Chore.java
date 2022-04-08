package com.example.pupbuddy.dto;

import com.example.pupbuddy.firestore.DocumentId;
import lombok.Data;

import java.util.Date;

public @Data class Chore {
    @DocumentId
    private String choreId;
    private String choreName;
    private boolean choreComplete;
    private Date choreStart;
    private Date choreEnd;
    private String dogId;
    private String humanId;

}
