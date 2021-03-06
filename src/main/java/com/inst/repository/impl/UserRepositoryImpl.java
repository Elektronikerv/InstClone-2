package com.inst.repository.impl;

import com.inst.entity.User;
import com.inst.repository.UserRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findUserByLogin(String login) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User where login=:login").setParameter("login", login).uniqueResult();
    }

    @Override
    public List<User> searchUsersByLogin(String login) {
        return (List<User>)sessionFactory.getCurrentSession()
                .createQuery("from User where login LIKE :login")
                .setParameter("login", "%" + login + "%").list();
    }

    @Override
    public void create(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User findById(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }
}
