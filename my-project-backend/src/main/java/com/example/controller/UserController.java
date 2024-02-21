package com.example.controller;


import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.entity.RestBean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/name")
    public RestBean name() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return RestBean.success(user.getUsername());
    }
}
