package org.neoa.ch05.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration
@ExtendWith(SpringExtension.class)
public class SingletonScopeTest {

    private AnnotationConfigApplicationContext context;

    @Configuration
    static class CommentServiceContextConfiguration {
        @Bean
        public CommentService commentService() {
            return new CommentService();
        }
    }

    @BeforeEach
    public void setup() {
        context = new AnnotationConfigApplicationContext(CommentServiceContextConfiguration.class);
    }

    @Test
    public void springContextReturnsSingleNameObject() {

        CommentService commentServiceOne = context.getBean(CommentService.class);
        CommentService commentServiceTwo = context.getBean(CommentService.class);

        boolean result = commentServiceOne == commentServiceTwo;

        assertThat(result).isTrue();
    }

}
