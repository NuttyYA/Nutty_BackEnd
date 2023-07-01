package com.nutty.app.comment.repository;

import com.nutty.app.comment.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {
    private final EntityManager em;

    public void createComment(Comment comment) {
        em.persist(comment);
    }
    public List<Comment> selectCommentList(Long noticeId){
        return em.createQuery("select c from Comment c" +
                        " join fetch c.notice n" +
                        " where n.id = :noticeId" +
                        " order by c.id desc", Comment.class)
                .setParameter("noticeId", noticeId)
                .getResultList();
    }
}
