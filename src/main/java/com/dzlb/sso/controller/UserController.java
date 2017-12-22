package com.dzlb.sso.controller;

import com.dzlb.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuhai on 2017/12/20.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



}
