package com.inst.repository;


import com.inst.entity.Like;

public interface LikeRepository {
    void create(Like like);

    void delete(Like like);
}
