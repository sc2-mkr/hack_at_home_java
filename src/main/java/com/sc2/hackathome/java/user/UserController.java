package com.sc2.hackathome.java.user;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/auth")
    public User greeting(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass) {
        return new User();
    }
}
