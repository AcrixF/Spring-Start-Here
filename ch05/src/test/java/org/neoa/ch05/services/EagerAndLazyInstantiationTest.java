package org.neoa.ch05.services;


import lombok.extern.java.Log;
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
@Log
public class EagerAndLazyInstantiationTest {

    @Configuration
    @ComponentScan(basePackages = {"org.neoa.ch05.services"})
    static class BeanInitializationConfiguration {

    }

    @Test
    public void springContextInitializeCommentServiceLazyWay() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanInitializationConfiguration.class);

        log.info("Spring Context Initializaded");

        CommentService commentService = context.getBean(CommentService.class);

        assertThat(commentService).isNotNull();

    }
}
