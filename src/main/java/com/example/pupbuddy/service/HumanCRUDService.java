package com.example.pupbuddy.service;

import com.example.pupbuddy.dto.Human;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class HumanCRUDService implements IHumanCRUDService{
    Firestore dbFirestore = FirestoreClient.getFirestore();

    @Override
    public String createHuman(Human human) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Humans").document(human.getHumanId()).set(human);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public Human getHuman(String humanId, String houseId) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = dbFirestore.collection("Houses").document(houseId).collection("Humans").document(humanId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Human human;
        if(document.exists()){
            human = document.toObject(Human.class);
            return human;
        }
        return null;
    }

    @Override
    public String updateHuman(Human human) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("Humans").document(human.getHumanId()).set(human);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public String deleteHuman(String humanId, String houseId) {
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("Houses").document(houseId).collection("Humans").document(humanId).delete();
        return "Successfully deleted " + humanId;
    }
}
