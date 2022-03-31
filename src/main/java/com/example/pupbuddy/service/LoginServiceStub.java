package com.example.pupbuddy.service;

import com.example.pupbuddy.dao.ILoginDAO;
import com.example.pupbuddy.dto.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceStub implements ILoginService{

    @Autowired
    ILoginDAO loginDAO;

    public LoginServiceStub(){}

    public LoginServiceStub(ILoginDAO loginDAO){this.loginDAO = loginDAO;}

    @Override
    public Login fetchById(int id) {
        Login foundLogin = loginDAO.fetch(id);
        return foundLogin;
    }

    @Override
    public void delete(int id) throws Exception {
        loginDAO.delete(id);
    }

    @Override
    public Login save(Login login) throws Exception {
        return loginDAO.save(login);
    }

    @Override
    public List<Login> fetchAll() {
        return loginDAO.fetchAll();
    }
}
