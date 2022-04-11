package com.example.pupbuddy.service;

import com.example.pupbuddy.dto.Dog;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class DogCRUDService implements IDogCRUDService{
    Firestore dbFirestore = FirestoreClient.getFirestore();

    @Override
    public String createDog(Dog dog) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Dogs").document(dog.getDogId()).set(dog);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public Dog getDog(String dogId) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = dbFirestore.collection("Dogs").document(dogId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Dog dog;
        if(document.exists()){
            dog = document.toObject(Dog.class);
            return dog;
        }
        return null;
    }

    @Override
    public String updateDog(Dog dog) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("Dogs").document(dog.getDogId()).set(dog);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public String deleteDog(String dogId) {
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("Dogs").document(dogId).delete();
        return "Successfully deleted " + dogId;
    }
}
