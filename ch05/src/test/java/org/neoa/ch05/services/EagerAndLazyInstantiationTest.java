package org.neoa.ch05.services;


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
public class EagerAndLazyInstantiationTest {

    @Configuration
    @ComponentScan(basePackages = {"org.neoa.ch05.services"})
    static class BeanInitializationConfiguration {

    }

    @Test
    public void springContextInitializeCommentServiceInEagerWay() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanInitializationConfiguration.class);

        assertThat(context).isNotNull();
    }
}
