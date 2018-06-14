package com.inst.service.impl;

import com.inst.entity.Image;
import com.inst.repository.ImageRepository;
import com.inst.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {


    private ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }


    @Override
    public void create(Image image) {
        imageRepository.create(image);
    }
}
