package com.inst.service;


import com.inst.entity.Image;
import com.inst.entity.Like;
import com.inst.entity.User;

import java.util.Collection;

public interface ImageService {

    void create(Image image);

    //    to deal with a hibernate contains method in persistSet bug
    boolean contains(Collection<Image> list, Image image);

    boolean containLikeByUser(User user, Image image);

    Image findById(int i);

    void likeImage(Like like);

    void unlikeImage(Like like);
}
