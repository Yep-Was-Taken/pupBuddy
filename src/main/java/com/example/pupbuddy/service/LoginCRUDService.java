package com.example.pupbuddy.service;

import com.example.pupbuddy.dto.Login;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class LoginCRUDService implements ILoginCRUDService {
    Firestore dbFirestore = FirestoreClient.getFirestore();

    @Override
    public String createLogin(Login login) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Logins").document(login.getLoginId()).set(login);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public Login getLogin(String loginId) throws ExecutionException, InterruptedException{
        DocumentReference documentReference = dbFirestore.collection("Logins").document(loginId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Login login;
        if(document.exists()){
            login = document.toObject(Login.class);
            return login;
        }
        return null;
    }

    @Override
    public String updateLogin(Login login) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("Logins").document(login.getLoginId()).set(login);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public String deleteLogin(String loginId) {
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("Logins").document(loginId).delete();
        return "Successfully deleted " + loginId;
    }
}
