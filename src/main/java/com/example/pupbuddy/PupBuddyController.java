package com.example.pupbuddy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PupBuddyController
 * Comment to document what PupBuddyController does
 */

@Controller
public class PupBuddyController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }
}
