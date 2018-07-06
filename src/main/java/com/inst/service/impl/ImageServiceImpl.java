package com.inst.service.impl;

import com.inst.entity.Image;
import com.inst.entity.Like;
import com.inst.entity.User;
import com.inst.repository.ImageRepository;
import com.inst.repository.LikeRepository;
import com.inst.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ImageServiceImpl implements ImageService {


    private ImageRepository imageRepository;
    private LikeRepository likeRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository, LikeRepository likeRepository) {
        this.imageRepository = imageRepository;
        this.likeRepository = likeRepository;
    }


    @Override
    public void create(Image image) {
        imageRepository.create(image);
    }

    @Override
    public boolean contains(Collection<Image> list, Image image) {
        for (Image i : list) {
            if (i.getId() == image.getId())
                return true;
        }

        return false;
    }

    @Override
    public boolean containLikeByUser(User user, Image image) {
        for (Like like : image.getLikes()) {
            if(like.getUser().getId() == user.getId())
                return true;
        }
        return false;
    }

    @Override
    public Image findById(int i) {
        return imageRepository.findById(i);
    }

    @Override
    public void likeImage(Like like) {
        likeRepository.create(like);
    }

    @Override
    public void unlikeImage(Like like) {
        likeRepository.delete(like);
    }
}
