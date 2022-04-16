package com.example.pupbuddy.dto;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Data;

public @Data
class Login {
    @DocumentId
    private String loginId;
    private String username;
    private String password;
    private int humanId;
}
