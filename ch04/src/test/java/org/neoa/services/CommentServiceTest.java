package org.neoa.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.neoa.model.Comment;
import org.neoa.proxies.CommentNotificationProxy;
import org.neoa.proxies.CommentPushNotificationProxy;
import org.neoa.proxies.EmailCommentNotificationProxy;
import org.neoa.repositories.CommentRepository;
import org.neoa.repositories.DBCommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration
@ExtendWith(SpringExtension.class)
public class CommentServiceTest {

    @Configuration
    @ComponentScan(basePackages = {"org.neoa.services", "org.neoa.repositories", "org.neoa.proxies"})
    static class CommentServiceTestContextConfiguration {

        @Bean
        public CommentNotificationProxy commentPushNotificationProxy() {
            return new CommentPushNotificationProxy();
        }

        @Bean
        public CommentNotificationProxy emailCommentNotificationProxy() {
            return new EmailCommentNotificationProxy();
        }

        @Bean
        public CommentRepository commentRepository() {
            return new DBCommentRepository();
        }

        @Bean
        public CommentService commentService() {
            return new CommentService(commentRepository(), commentPushNotificationProxy());
        }
    }

    @Test
    public void springContextReturnsExpectedBeanWithMultipleImplementationsOfAnAbstractionWhenUsingQualifierAnnotation() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CommentServiceTestContextConfiguration.class);
        CommentService commentService = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Testing Dependency Injection Using Abstraction");
        comment.setAuthor("BM");

        commentService.publishComment(comment);

        assertThat(commentService.isCommentPushNotificationProxyInstance()).isTrue();
    }
}
