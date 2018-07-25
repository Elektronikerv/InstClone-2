package com.inst.repository.impl;

import com.inst.entity.Image;
import com.inst.entity.User;
import com.inst.repository.ImageRepository;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

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

    @Override
    public List<Image> findAllFollowingImages(User user) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("select i from User u join u.following f join f.images i " +
                             " where u.id=:follower_id order by i.createdOn desc");
        query.setParameter("follower_id", user.getId());
        return query.list();
    }

    @Override
    public void delete(Image image) {
        sessionFactory.getCurrentSession().delete(image);
    }
}