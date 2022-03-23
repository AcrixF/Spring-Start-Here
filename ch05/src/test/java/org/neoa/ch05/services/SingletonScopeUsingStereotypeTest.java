package org.neoa.ch05.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration
@ExtendWith(SpringExtension.class)
public class SingletonScopeUsingStereotypeTest {

    @Configuration
    @ComponentScan(basePackages = {"org.neoa.ch05.services", "org.neoa.ch05.repositories"})
    static class CommentServiceContextConfigurationStereotype {

    }

    private AnnotationConfigApplicationContext context;

    @BeforeEach
    public void setup() {
        context = new AnnotationConfigApplicationContext(CommentServiceContextConfigurationStereotype.class);
    }

    @Test
    public void springContextReturnsSingletonBeanUsingStereotypeAnnotations() {
        CommentService commentService = context.getBean(CommentService.class);
        UserService userService = context.getBean(UserService.class);

        boolean result = commentService.getCommentRepository() == userService.getCommentRepository();

        assertThat(result).isTrue();
    }

}
