package com.example.pupbuddy.service;

import com.example.pupbuddy.dto.Chore;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class ChoreCRUDService implements IChoreCRUDService{
    Firestore dbFirestore = FirestoreClient.getFirestore();

    @Override
    public String createChore(Chore chore) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Chores").document(chore.getChoreId()).set(chore);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public Chore getChore(String choreId, String houseId) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = dbFirestore.collection("Houses").document(houseId).collection("Chores").document(choreId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Chore chore;
        if(document.exists()){
            chore = document.toObject(Chore.class);
            return chore;
        }
        return null;
    }

    @Override
    public String updateChore(Chore chore) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("Houses").document(chore.getHouseId()).collection("Chores").document(chore.getChoreId()).set(chore);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public String deleteChore(String choreId, String houseId) {
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("Houses").document(houseId).collection("Chores").document(choreId).delete();
        return "Successfully deleted " + choreId;
    }
}
