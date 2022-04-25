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
    public String createDog(Dog dog, String houseId) throws ExecutionException, InterruptedException {
        dog.setHouseId(houseId);
        ApiFuture<DocumentReference> collectionsApiFuture = dbFirestore.collection("Houses").document(houseId).collection("Dogs").add(dog);
        dog.setDogId(collectionsApiFuture.get().getId());

        return "";
    }

    @Override
    public Dog getDog(String dogId, String houseId) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = dbFirestore.collection("Houses").document(houseId).collection("Dogs").document(dogId);
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
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("Houses").document(dog.getHouseId()).collection("Dogs").document(dog.getDogId()).set(dog);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public String deleteDog(String dogId, String houseId) {
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("Houses").document(houseId).collection("Dogs").document(dogId).delete();
        return "Successfully deleted " + dogId;
    }
}
