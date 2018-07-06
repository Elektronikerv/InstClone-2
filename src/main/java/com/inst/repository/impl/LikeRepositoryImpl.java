package com.inst.repository.impl;

import com.inst.entity.Like;
import com.inst.repository.LikeRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LikeRepositoryImpl implements LikeRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public LikeRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Like like) {
        sessionFactory.getCurrentSession().save(like);
    }

    @Override
    public void delete(Like like) {
        sessionFactory.getCurrentSession().delete(like);
    }
}
