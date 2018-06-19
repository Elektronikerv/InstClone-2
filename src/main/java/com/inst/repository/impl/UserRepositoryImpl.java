package com.inst.repository.impl;

import com.inst.entity.User;
import com.inst.repository.UserRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public User findUserByLogin(String login) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User where login=:login").setParameter("login", login).uniqueResult();
    }

    @Override
    @Transactional
    public List<User> searchUsersByLogin(String login) {
        return (List<User>)sessionFactory.getCurrentSession()
                .createQuery("from User where login LIKE :login")
                .setParameter("login", "%" + login + "%").list();
    }

    @Override
    @Transactional
    public void create(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @Transactional
    public User findById(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }
}
