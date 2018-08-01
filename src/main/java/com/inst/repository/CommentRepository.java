package com.inst.repository;

import com.inst.entity.Comment;

public interface CommentRepository {
    void create(Comment comment);

    Comment findById(int id);

    void delete(Comment comment);
}
