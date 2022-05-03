package com.terzo.assetmanagement.RestController;

import com.terzo.assetmanagement.entity.User;
import com.terzo.assetmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assetmanagement")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    public UserRestController() {

    }


    @GetMapping("/user/all")
    public List<User> findAll() {
        return userService.findAll();
    }



    @GetMapping("/user/{Id}")
    public Optional<User> getUser(@PathVariable int Id) {

        Optional<User> theUser = userService.findById(Id);

        if (theUser.isEmpty()) {
            throw new RuntimeException("Asset id not found - " + Id);
        }

        return theUser ;
    }



    @PostMapping("/user")
    public User addUser(@RequestBody User theUser) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theUser.setUserId(0);

        userService.save(theUser);

        return theUser;
    }

    // add mapping for PUT  - update existing users

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User theUser) {

        Optional<User> user = userService.findById(id);
        if(user.isEmpty()) {
            throw new RuntimeException("user id not found "+ id);
        }
        theUser.setUserId(id);
        userService.save(theUser);
        return theUser;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/user/{Id}")
    public String deleteUser(@PathVariable int Id) {

        Optional<User> tempUser = userService.findById(Id);

        // throw exception if null

        if (tempUser.isEmpty()) {
            throw new RuntimeException("Asset id not found - " + Id);
        }

        userService.deleteById(Id);

        return "Deleted Asset id - " + Id;
    }
}
