package com.inst.repository.impl;

import com.inst.entity.User;
import com.inst.repository.UserRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public User findUserByEmail(String email) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User where email=:email").setParameter("email", email).uniqueResult();
    }
}
