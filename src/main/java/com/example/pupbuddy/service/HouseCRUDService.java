package com.example.pupbuddy.service;

import com.example.pupbuddy.dto.House;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;


import java.util.concurrent.ExecutionException;

@Service
public class HouseCRUDService implements IHouseCRUDService{
    Firestore dbFirestore = FirestoreClient.getFirestore();

    @Override
    public String createHouse(House house) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Houses").document(house.getHouseId()).set(house);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public House getHouse(String houseId) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = dbFirestore.collection("Houses").document(houseId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        House house;
        if(document.exists()){
            house = document.toObject(House.class);
            return house;
        }
        return null;
    }

    @Override
    public String updateHouse(House house) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("Houses").document(house.getHouseId()).set(house);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public String deleteHouse(String houseId) {
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("Houses").document(houseId).delete();
        return "Successfully deleted " + houseId;
    }
}
