package org.neoa.proxies;

import org.neoa.model.Comment;

public interface CommentNotificationProxy {

    void sendComment(Comment comment);
}
