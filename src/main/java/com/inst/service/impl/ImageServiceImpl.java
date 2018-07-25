package com.inst.service.impl;

import com.inst.entity.Comment;
import com.inst.entity.Image;
import com.inst.entity.Luke;
import com.inst.entity.User;
import com.inst.exception.EntityNotFoundException;
import com.inst.exception.NoAccessException;
import com.inst.repository.CommentRepository;
import com.inst.repository.ImageRepository;
import com.inst.repository.LikeRepository;
import com.inst.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {


    private ImageRepository imageRepository;
    private LikeRepository likeRepository;
    private CommentRepository commentRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository, LikeRepository likeRepository, CommentRepository commentRepository) {
        this.imageRepository = imageRepository;
        this.likeRepository = likeRepository;
        this.commentRepository = commentRepository;
    }


    @Override
    public void create(Image image) {
        if (image == null)
            throw new EntityNotFoundException("Image entity is null");
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
        for (Luke like : image.getLikes()) {
            if(like.getUser().getId() == user.getId())
                return true;
        }
        return false;
    }

    @Override
    public Image findById(int id) {
        if( id < 0)
            throw new IllegalArgumentException("Image id is less than 0");
        return imageRepository.findById(id);
    }

    @Override
    public void likeImage(Luke like) {
        if (like == null)
            throw new EntityNotFoundException("Like entity is null");
        likeRepository.create(like);
    }

    @Override
    public void unlikeImage(Luke like) {
        if (like == null)
            throw new EntityNotFoundException("Like entity is null");
        likeRepository.delete(like);
    }

    @Override
    public List<User> findAllImageLikers(int imageId) {
        if( imageId < 0)
            throw new IllegalArgumentException("Image id is less than 0");

        Image image = this.findById(imageId);

        return likeRepository.findAllImageLikers(image);
    }

    @Override
    public void commentImage(Comment comment) {
        if (comment == null)
            throw new EntityNotFoundException("Comment entity is null");
        commentRepository.create(comment);
    }

    @Override
    public List<Image> findAllFollowingImages(User user) {
        return imageRepository.findAllFollowingImages(user);
    }

    @Override
    public void delete(Image image, User user) {
        if (this.contains(user.getImages(), image))
            imageRepository.delete(image);
        else {
            throw new NoAccessException("User with id " + user.getId() + " try to delete another user image");
        }
    }
}
