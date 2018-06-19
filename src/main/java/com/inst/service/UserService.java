package com.inst.service;

import com.inst.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {

    void create(User user);

    User findById(int id);

    List<User> searchUsersByLogin(String login);
}
