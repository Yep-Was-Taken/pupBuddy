package com.example.pupbuddy.dao;

import com.example.pupbuddy.dto.House;
import com.example.pupbuddy.firestore.AbstractFirestoreRepository;
import com.google.cloud.firestore.Firestore;
import org.springframework.stereotype.Repository;

@Repository
public class HouseRepository extends AbstractFirestoreRepository<House> {
    protected HouseRepository(Firestore firestore, String collection) {
        super(firestore, collection);
    }
}
