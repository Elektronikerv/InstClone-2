package com.inst.service;

import com.inst.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    void create(User user);

    User findById(int id);
}
