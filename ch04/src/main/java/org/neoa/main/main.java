package org.neoa.main;

import org.neoa.model.Comment;
import org.neoa.proxies.CommentNotificationProxy;
import org.neoa.proxies.EmailCommentNotificationProxy;
import org.neoa.repositories.CommentRepository;
import org.neoa.repositories.DBCommentRepository;
import org.neoa.services.CommentService;

public class main {

    public static void main(String[] args) {
        CommentRepository commentRepository = new DBCommentRepository();
        CommentNotificationProxy commentNotificationProxy = new EmailCommentNotificationProxy();

        CommentService commentService = new CommentService(commentRepository, commentNotificationProxy);

        Comment comment = new Comment();
        comment.setAuthor("Neoa");
        comment.setText("Demo Comment");

        commentService.publishComment(comment);
    }
}
