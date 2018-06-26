package com.inst.service;

import com.inst.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.List;


public interface UserService extends UserDetailsService {

    void create(User user);

    User findById(int id);

    List<User> searchUsersByLogin(String login);

    void subscribe(User currentUser, User user);

    void unsubscribe(User currentUser, User user);

    //    to deal with a hibernate contains method in persistSet bug
    boolean contains(Collection<User> list, User user);
}
