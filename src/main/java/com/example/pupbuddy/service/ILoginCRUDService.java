package com.example.pupbuddy.service;

import com.example.pupbuddy.dto.Login;

import java.util.concurrent.ExecutionException;

public interface ILoginCRUDService {
    public String createLogin(Login login) throws ExecutionException, InterruptedException ;
    public Login getLogin(int loginId);
    public String updateLogin(Login login);
    public String deleteLogin(int loginId);
}
