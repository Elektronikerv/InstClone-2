package com.inst.repository;


import com.inst.entity.Image;
import com.inst.entity.Luke;
import com.inst.entity.User;

import java.util.List;

public interface LikeRepository {
    void create(Luke like);

    void delete(Luke like);

    List findAllImageLikers(Image image);
}
