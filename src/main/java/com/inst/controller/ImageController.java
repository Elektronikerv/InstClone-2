package com.inst.controller;

import com.inst.entity.Image;
import com.inst.entity.Like;
import com.inst.entity.User;
import com.inst.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImageController {

    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @RequestMapping("/image/{id}")
    public String getImage(@PathVariable("id") int id,
                           @AuthenticationPrincipal User user,
                           Model model) {
        Image image = imageService.findById(id);

        if (imageService.containLikeByUser(user, image))
            model.addAttribute("state", "liked");
        else
            model.addAttribute("state", "unliked");

        model.addAttribute("image", image);
        model.addAttribute("currentUser", user);
        return "imagePage";
    }

    @RequestMapping("/image/{type}/{id}")
    public String likeImage(@PathVariable("type") String type,
                            @PathVariable("id") int id,
                            @AuthenticationPrincipal User user) {
        Image image = imageService.findById(id);
        if (type.equals("like")) {
            Like like = new Like();
            like.setUser(user);
            like.setImage(image);
            image.addLike(like);
            imageService.likeImage(like);
        }
        else if (type.equals("unlike")) {
            Like like = image.getLikeByUser(user);
            image.removeLikeByUser(like);
            imageService.unlikeImage(like);
        }

        return "forward:/image/" + id;
    }

}