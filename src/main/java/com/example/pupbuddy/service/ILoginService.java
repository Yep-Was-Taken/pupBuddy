package com.example.pupbuddy.service;

import com.example.pupbuddy.dto.Login;

import java.util.List;

public interface ILoginService {

    Login fetchById(int id);

    void delete(int id) throws Exception;

    Login save(Login login) throws Exception;

    List<Login> fetchAll();
}