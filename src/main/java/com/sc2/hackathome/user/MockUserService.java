package com.sc2.hackathome.user;

import org.springframework.stereotype.Service;

@Service
public class MockUserService implements UserService {
    @Override
    public User getCurrentUser() {
        User user = new User();
        user.setId(1L);
        return user;
    }
}
