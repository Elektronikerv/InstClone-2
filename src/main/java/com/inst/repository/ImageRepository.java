package com.inst.repository;


import com.inst.entity.Image;

public interface ImageRepository {
    void create(Image image);

    Image findById(int i);
}
