package com.example.pupbuddy.service;

import com.example.pupbuddy.dto.Login;

import java.util.concurrent.ExecutionException;

public interface ILoginCRUDService {
    public String createLogin(Login login) throws ExecutionException, InterruptedException;
    public Login getLogin(String loginId) throws ExecutionException, InterruptedException;
    public String updateLogin(Login login) throws ExecutionException, InterruptedException;
    public String deleteLogin(String loginId);
}
