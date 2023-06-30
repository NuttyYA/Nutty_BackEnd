package com.nutty.app.comment.repository;

import com.nutty.app.comment.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class CommentRepository {
    private final EntityManager em;

    public void createComment(Comment comment) {
        em.persist(comment);
    }
}
