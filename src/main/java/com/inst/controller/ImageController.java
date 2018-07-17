package com.inst.controller;

import com.inst.entity.Comment;
import com.inst.entity.Image;
import com.inst.entity.Luke;
import com.inst.entity.User;
import com.inst.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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
            Luke like = new Luke();
            like.setUser(user);
            like.setImage(image);
            image.addLike(like);
            imageService.likeImage(like);
        }
        else if (type.equals("unlike")) {
            Luke like = image.getLikeByUser(user);
            image.removeLikeByUser(like);
            imageService.unlikeImage(like);
        }

        return "forward:/image/" + id;
    }

    @RequestMapping("/image/{id}/likesList")
    public String getLikesList(@PathVariable("id") int id,
                               Model model) {
        List<User> likers =  imageService.findAllImageLikers(id);
        model.addAttribute("users", likers);
        return "usersList";
    }

    @RequestMapping(value = "image/comment", method = RequestMethod.POST)
    public String commentImage(@RequestParam("id") int id,
                               @RequestParam("text") String text,
                               @AuthenticationPrincipal User user) {

        Comment comment = new Comment();
        comment.setText(text);
        Image image = imageService.findById(id);

        comment.setUser(user);
        image.addComment(comment);
        imageService.commentImage(comment);

        return "redirect:/image/" + id;
    }

    @RequestMapping("/image/add")
    public String addImagePage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("currentUser", user);
        return "addImage";
    }


    @RequestMapping(value = "/image/add", method = RequestMethod.POST)
    public String addImage(@AuthenticationPrincipal User user,
                           @RequestParam("newImage") MultipartFile file,
                           @RequestParam("description") String description) throws IOException {
        Image image = new Image();
        image.setContent(file);
        image.setUser(user);
        image.setDescription(description);
        imageService.create(image);

        return "redirect:/";
    }
}