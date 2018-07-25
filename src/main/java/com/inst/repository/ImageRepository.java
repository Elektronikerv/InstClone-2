package com.inst.repository;


import com.inst.entity.Image;
import com.inst.entity.User;

import java.util.List;

public interface ImageRepository {
    void create(Image image);

    Image findById(int i);

    List findAllFollowingImages(User user);

    void delete(Image image);
}
