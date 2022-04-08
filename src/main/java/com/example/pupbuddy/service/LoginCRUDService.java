package com.example.pupbuddy.service;

import com.example.pupbuddy.dto.Login;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class LoginCRUDService implements ILoginCRUDService {
    @Override
    public String createLogin(Login login) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Logins").document(login.getUsername()).set(login);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public Login getLogin(int loginId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        return null;
    }

    @Override
    public String updateLogin(Login login) {
        return null;
    }

    @Override
    public String deleteLogin(int loginId) {
        return null;
    }
}
