package com.manish.security.controller;

import com.manish.security.dao.AuthRequest;
import com.manish.security.dao.UserInfoDTO;
import com.manish.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfoDTO userInfoDTO){
        return userService.addNewUser(userInfoDTO);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest){
        return userService.authenticateAndGetToken(authRequest);
    }
}
