package com.inst.entity;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;
import org.hibernate.annotations.OrderBy;
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
    private Set<Luke> likes;

    @OneToMany(mappedBy = "image",
               cascade = CascadeType.ALL,
               fetch = FetchType.EAGER)
    @OrderBy(clause = "created_on ASC")
    private Set<Comment> comments;

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

    public Set<Luke> getLikes() {
        return likes;
    }

    public void setLikes(Set<Luke> likes) {
        this.likes = likes;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
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

    public void addLike(Luke like) {
        if (likes == null)
            likes = new HashSet<>();
        like.setImage(this);
        likes.add(like);
    }

    public Luke getLikeByUser(User user) {
        Luke searchedLike = null;
        for (Luke like : likes) {
            if(like.getUser().getId() == user.getId())
                searchedLike = like;
        }
        return searchedLike;
    }

    public void addComment(Comment comment) {
        if (comments == null)
            comments = new HashSet<>();
        comment.setImage(this);
        comments.add(comment);
    }

    public void removeLikeByUser(Luke like) {
            likes.remove(like);
    }
}
