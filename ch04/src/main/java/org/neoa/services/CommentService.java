package org.neoa.services;

import org.neoa.model.Comment;
import org.neoa.proxies.CommentNotificationProxy;
import org.neoa.proxies.CommentPushNotificationProxy;
import org.neoa.repositories.CommentRepository;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }


    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }

    public boolean isCommentPushNotificationProxyInstance() {
        return commentNotificationProxy instanceof CommentPushNotificationProxy;
    }

}
