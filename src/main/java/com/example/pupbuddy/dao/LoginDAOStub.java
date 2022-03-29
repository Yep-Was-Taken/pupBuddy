package com.example.pupbuddy.dao;

import com.example.pupbuddy.dto.Login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginDAOStub implements ILoginDAO{

    private Map<Integer, Login> allLogins = new HashMap<>();

    @Override
    public Login save(Login login) throws Exception {
        Integer loginId = login.getLoginId();
        allLogins.put(loginId, login);
        return login;
    }

    @Override
    public List<Login> fetchAll() {
        List<Login> loginList = new ArrayList<>(allLogins.values());
        return loginList;
    }

    @Override
    public Login fetch(int id) {
        return allLogins.get(id);
    }

    @Override
    public void delete(int id) {
        allLogins.remove(id);
    }
}