package com.example.pupbuddy;

import com.example.pupbuddy.dto.*;
import com.example.pupbuddy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * PupBuddyController
 * Comment to document what PupBuddyController does
 */

@Controller
public class PupBuddyController {

    @Autowired
    IChoreService choreService;

    @Autowired
    IHumanService humanService;

    @Autowired
    IDogService dogService;

    @Autowired
    IHouseService houseService;

    @Autowired
    ILoginService loginService;

    @RequestMapping("/")
    public String index(){
        return "home";
    }



}