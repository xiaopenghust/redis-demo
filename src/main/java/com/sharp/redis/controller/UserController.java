package com.sharp.redis.controller;

import com.sharp.redis.domain.User;
import com.sharp.redis.service.IUserOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 584003 on 2017/5/2.
 */
@Controller
@RequestMapping(value = "/redis")
public class UserController {
    @Autowired
    private IUserOperationsService userOperationsService;
    private User user;

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(
            @RequestParam(value = "Id", required = true) String Id,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "password", required = true) String password) {

        user = new User(Id, name, password);
        userOperationsService.add(user);
        return "success";
    }

}