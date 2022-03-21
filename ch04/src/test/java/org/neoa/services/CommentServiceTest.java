package org.neoa.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.neoa.model.Comment;
import org.neoa.proxies.CommentNotificationProxy;
import org.neoa.proxies.EmailCommentNotificationProxy;
import org.neoa.repositories.CommentRepository;
import org.neoa.repositories.DBCommentRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
@ExtendWith(SpringExtension.class)
public class CommentServiceTest {

    @Configuration
    static class CommentServiceTestContextConfiguration {

        @Bean
        public CommentRepository commentRepository() {
            return new DBCommentRepository();
        }

        @Bean
        public CommentNotificationProxy commentNotificationProxy() {
            return new EmailCommentNotificationProxy();
        }

        @Bean
        public CommentService commentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
            return new CommentService(commentRepository, commentNotificationProxy);
        }
    }

    @Test
    public void publishCommentSendNotification() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CommentServiceTestContextConfiguration.class);

        CommentService commentService = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Testing Dependency Injection Using Abstraction");
        comment.setAuthor("BM");

        commentService.publishComment(comment);
    }
}
