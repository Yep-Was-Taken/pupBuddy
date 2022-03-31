package com.example.pupbuddy.dao;

import com.example.pupbuddy.dto.Human;
import com.example.pupbuddy.dto.Login;

import java.util.List;

public interface ILoginDAO {
    Login save(Login login) throws Exception;

    List<Login> fetchAll();

    Login fetch(int id);

    void delete(int id);
}