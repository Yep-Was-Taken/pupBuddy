package com.example.pupbuddy;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class PupBuddyApplication {

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = PupBuddyApplication.class.getClassLoader();

        FileInputStream serviceAccount = new FileInputStream("C:/Users/Molly/Documents/service-account-file.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();


        FirebaseApp.initializeApp(options);

        SpringApplication.run(PupBuddyApplication.class, args);
    }

}
