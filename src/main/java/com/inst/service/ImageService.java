package com.inst.service;


import com.inst.entity.Comment;
import com.inst.entity.Image;
import com.inst.entity.Luke;
import com.inst.entity.User;

import java.util.Collection;
import java.util.List;

public interface ImageService {

    void create(Image image);

    //    to deal with a hibernate contains method in persistSet bug
    boolean contains(Collection<Image> list, Image image);

    boolean containLikeByUser(User user, Image image);

    Image findById(int i);

    void likeImage(Luke like);

    void unlikeImage(Luke like);

    List<User> findAllImageLikers(int imageId);

    void commentImage(Comment comment);

    List<Image> findAllFollowingImages(User user);

    void delete(int id, User user);
}
