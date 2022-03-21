package org.neoa.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.neoa.model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration
@ExtendWith(SpringExtension.class)
public class CommentServiceTest {

    @Configuration
    @ComponentScan(basePackages = {"org.neoa.services", "org.neoa.repositories", "org.neoa.proxies"})
    static class CommentServiceTestContextConfiguration {

        @Bean
        public CommentService commentService() {
            return new CommentService();
        }
    }

    @Test
    public void springContextReturnsExpectedBeanWithMultipleImplementationsOfAnAbstraction() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CommentServiceTestContextConfiguration.class);
        CommentService commentService = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Testing Dependency Injection Using Abstraction");
        comment.setAuthor("BM");

        commentService.publishComment(comment);
    }
}
