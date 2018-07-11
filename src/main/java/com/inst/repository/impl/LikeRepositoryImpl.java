package com.inst.repository.impl;

import com.inst.entity.Image;
import com.inst.entity.Luke;
import com.inst.entity.User;
import com.inst.repository.LikeRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Query;
import java.util.List;

@Repository
@Transactional
public class LikeRepositoryImpl implements LikeRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public LikeRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Luke like) {
        sessionFactory.getCurrentSession().save(like);
    }

    @Override
    public void delete(Luke like) {
        sessionFactory.getCurrentSession().delete(like);
    }

    @Override
    public List<User> findAllImageLikers(Image image) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("select u from Luke l JOIN l.user u WHERE image_id=:image_id");
        query.setParameter("image_id", image.getId());

        return query.list();
    }
}
