package org.neoa.repositories;

import org.neoa.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
