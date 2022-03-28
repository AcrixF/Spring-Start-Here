package org.neoa.ch05.services;

import lombok.extern.java.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration
@ExtendWith(SpringExtension.class)
@Log
public class PrototypeBeanDefinitionTest {

    @Configuration
    @ComponentScan(basePackages = {"org.neoa.ch05.services"})
    static class PrototypeBeanInitializationConfiguration {

        @Bean
        @Scope(BeanDefinition.SCOPE_PROTOTYPE)
        public CommentService commentService() {
            return new CommentService();
        }
    }

    private AnnotationConfigApplicationContext context;

    @BeforeEach
    public void setup() {
        context = new AnnotationConfigApplicationContext(PrototypeBeanInitializationConfiguration.class);
    }

    @Test
    public void springContextReturnsPrototypeInstances() {

        CommentService instanceOne = context.getBean(CommentService.class);

        CommentService instanceTwo = context.getBean(CommentService.class);

        assertThat(instanceOne).isNotEqualTo(instanceTwo);

    }

}
