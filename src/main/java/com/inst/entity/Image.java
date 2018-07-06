package com.inst.entity;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "created_on")
    @CreationTimestamp
    private Timestamp createdOn;

    @OneToMany(mappedBy = "image",
            cascade = CascadeType.ALL,
               fetch = FetchType.EAGER)
//    @JoinColumn(name = "image_id")
    private Set<Like> likes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setContent(MultipartFile file) throws IOException {
        byte[] encode  = Base64.encodeBase64(file.getBytes());
        content = new String(encode);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public Set<Like> getLikes() {
        return likes;
    }

    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Image image = (Image) obj;
        if (this.id == image.getId())
            return true;

        return false;
    }

    public void addLike(Like like) {
        if (likes == null)
            likes = new HashSet<>();
        like.setImage(this);
        likes.add(like);
    }

    public Like getLikeByUser(User user) {
        Like searchedLike = null;
        for (Like like : likes) {
            if(like.getUser().getId() == user.getId())
                searchedLike = like;
        }
        return searchedLike;
    }

    public void removeLikeByUser(Like like) {
            likes.remove(like);
    }
}
