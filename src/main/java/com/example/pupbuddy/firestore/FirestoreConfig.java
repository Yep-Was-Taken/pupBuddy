package com.example.pupbuddy.firestore;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirestoreConfig {
    @Bean
    public Firestore getFireStore(@Value("${firebase.credential.path}") String credentialPath) throws IOException {
        var serviceAccount = new FileInputStream(credentialPath);
        var credentials = GoogleCredentials.fromStream(serviceAccount);

        var options = FirestoreOptions.newBuilder()
                .setCredentials(credentials).build();

        return options.getService();
    }
}