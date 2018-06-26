package com.inst.repository;


import com.inst.entity.User;

import java.util.List;

public interface UserRepository {
    User findUserByLogin(String login);

    List<User> searchUsersByLogin(String login);

    void create(User user);

    User findById(int id);

    void delete(User user);
}
