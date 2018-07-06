package com.inst.repository.impl;

import com.inst.entity.Image;
import com.inst.repository.ImageRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ImageRepositoryImpl implements ImageRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public ImageRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Image image) {
        sessionFactory.getCurrentSession().save(image);
    }

    @Override
    public Image findById(int i) {
        return sessionFactory.getCurrentSession().get(Image.class, i);
    }
}