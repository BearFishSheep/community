package com.nocoder.community.service;

import com.nocoder.community.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findCommentsByEntity(int entityType, int entityId, int offset, int limit);

    int findCountByEntity(int entityType, int entityId);

    int addComment(Comment comment);

    Comment findCommentById(int id);
}
