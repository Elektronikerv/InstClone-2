package com.inst.repository;


import com.inst.entity.User;

public interface UserRepository {
    User findUserByEmail(String email);

    void create(User user);

    User findById(int id);
}
