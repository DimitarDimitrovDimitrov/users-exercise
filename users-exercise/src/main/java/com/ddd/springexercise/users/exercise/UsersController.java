package com.ddd.springexercise.users.exercise;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UsersController {

    private ArrayList<Users> usersArrayList = new ArrayList<>() {
    };

    @GetMapping("/users")
    public Object[] getAllUsers() {

        return usersArrayList.toArray();
    }

    @GetMapping("/users/active")
    public Object[] getActiveUsers(String status) {
        ArrayList<Users> activeList = new ArrayList<>();
        for (Users users : usersArrayList) {
            if (users.getStatus().equals("active")) {
                activeList.add(users);
            }
        }

        return activeList.toArray();
    }

    @GetMapping("/users/inactive")
    public Object[] getInactiveUsers(String status) {
        ArrayList<Users> inactiveList = new ArrayList<>();
        for (Users users : usersArrayList) {
            if (users.getStatus().equals("inactive")) {
                inactiveList.add(users);
            }
        }

        return inactiveList.toArray();
    }

    @RequestMapping("/users/createuser")
    public Users createUser(@RequestBody Users users) {
        users.setId(UUID.randomUUID().toString());

        usersArrayList.add(users);
        return users;
    }
}
