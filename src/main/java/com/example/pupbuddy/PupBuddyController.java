package com.example.pupbuddy;

import com.example.pupbuddy.dto.*;
import com.example.pupbuddy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

/**
 * PupBuddyController
 */

@Controller
public class PupBuddyController {

    @Autowired
    public IChoreCRUDService choreCrudService;

    @Autowired
    public IHumanCRUDService humanCrudService;

    @Autowired
    public IDogCRUDService dogCrudService;

    @Autowired
    public IHouseCRUDService houseCrudService;

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

    @PostMapping("/createChore")
    public String createChore(@RequestBody Chore chore) throws ExecutionException, InterruptedException {
        return choreCrudService.createChore(chore);
    }

    @GetMapping("/getChore")
    public Chore getChore(@RequestParam String choreId, String houseId) throws InterruptedException, ExecutionException {
        return choreCrudService.getChore(choreId, houseId);
    }

    @PutMapping("/updateChore")
    public String updateChore(@RequestBody Chore chore) throws InterruptedException, ExecutionException {
        return choreCrudService.updateChore(chore);
    }

    @DeleteMapping("/deleteChore")
    public String deleteChore(@RequestParam String choreId, String houseId) throws InterruptedException, ExecutionException {
        return choreCrudService.deleteChore(choreId, houseId);
    }

    @PostMapping("/createDog")
    public String createDog(@RequestBody Dog dog) throws ExecutionException, InterruptedException {
        return dogCrudService.createDog(dog);
    }

    @GetMapping("/getDog")
    public Dog getDog(@RequestParam String dogId, String houseId) throws InterruptedException, ExecutionException {
        return dogCrudService.getDog(dogId, houseId);
    }

    @PutMapping("/updateDog")
    public String updateDog(@RequestBody Dog dog) throws InterruptedException, ExecutionException {
        return dogCrudService.updateDog(dog);
    }

    @DeleteMapping("/deleteDog")
    public String deleteDog(@RequestParam String dogId, String houseId) throws InterruptedException, ExecutionException {
        return dogCrudService.deleteDog(dogId, houseId);
    }

    @PostMapping("/createHouse")
    public String createHouse(@RequestBody House dog) throws ExecutionException, InterruptedException {
        return houseCrudService.createHouse(dog);
    }

    @GetMapping("/getHouse")
    public House getHouse(@RequestParam String houseId) throws InterruptedException, ExecutionException {
        return houseCrudService.getHouse(houseId);
    }

    @PutMapping("/updateHouse")
    public String updateHouse(@RequestBody House house) throws InterruptedException, ExecutionException {
        return houseCrudService.updateHouse(house);
    }

    @DeleteMapping("/deleteHouse")
    public String deleteHouse(@RequestParam String houseId) throws InterruptedException, ExecutionException {
        return houseCrudService.deleteHouse(houseId);
    }

    @PostMapping("/createHuman")
    public String createHuman(@RequestBody Human human) throws ExecutionException, InterruptedException {
        return humanCrudService.createHuman(human);
    }

    @GetMapping("/getHuman")
    public Human getHuman(@RequestParam String humanId, String houseId) throws InterruptedException, ExecutionException {
        return humanCrudService.getHuman(humanId, houseId);
    }

    @PutMapping("/updateHuman")
    public String updateHuman(@RequestBody Human human) throws InterruptedException, ExecutionException {
        return humanCrudService.updateHuman(human);
    }

    @DeleteMapping("/deleteHuman")
    public String deleteHuman(@RequestParam String humanId, String houseId) throws InterruptedException, ExecutionException {
        return humanCrudService.deleteHuman(humanId, houseId);
    }
}