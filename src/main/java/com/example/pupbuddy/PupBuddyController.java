package com.example.pupbuddy;

import com.example.pupbuddy.dto.*;
import com.example.pupbuddy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

/**
 * PupBuddyController
 * Comment to document what PupBuddyController does
 */

@Controller
public class PupBuddyController {

    @Autowired
    public IChoreService choreService;

    @Autowired
    public IHumanService humanService;

    @Autowired
    public IDogService dogService;

    @Autowired
    public IHouseService houseService;

    @Autowired
    public ILoginService loginService;

    @Autowired
    public ILoginCRUDService crudService;

    @RequestMapping("/")
    public String index(){
        return "home";
    }

    @PostMapping("/createLogin")
    public String createLogin(@RequestBody Login login) throws InterruptedException, ExecutionException {
        return crudService.createLogin(login);
    }

    @GetMapping("/getLogin")
    public Login getLogin(@RequestParam String loginId) throws InterruptedException, ExecutionException {
        return crudService.getLogin(loginId);
    }

    @PutMapping("/updateLogin")
    public String updateLogin(@RequestBody Login login) throws InterruptedException, ExecutionException {
        return crudService.updateLogin(login);
    }

    @DeleteMapping("/deleteLogin")
    public String deleteLogin(@RequestParam String loginId) throws InterruptedException, ExecutionException {
        return crudService.deleteLogin(loginId);
    }

}