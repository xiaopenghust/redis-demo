package com.sharp.redis.controller;

import com.sharp.redis.domain.User;
import com.sharp.redis.service.IUserOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 584003 on 2017/5/2.
 */
@RestController
@RequestMapping(value = "/redis")
public class UserController {
    @Autowired
    private IUserOperationsService userOperationsService;
    private User user;

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(
            @RequestParam(value = "id", required = true) String id,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "password", required = true) String password) {

        user = new User(id, name, password);
        userOperationsService.add(user);
        return "success";
    }

    @RequestMapping(value = "/removeUser", method = RequestMethod.GET)
    public String removeUser(
            @RequestParam(value = "Id", required = true) String id){
        userOperationsService.removeUser(id);
        return "success";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String updateUser(
            @RequestParam(value = "id", required = true) String id,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "password", required = true) String password) {
        user = new User(id, name, password);
        userOperationsService.add(user);
        return "success";
    }

    @RequestMapping(value = "/queryUser", method = RequestMethod.GET)
    public User queryUser(@RequestParam(value = "id", required = true) String id){
        return userOperationsService.queryUser(id);
    }

}