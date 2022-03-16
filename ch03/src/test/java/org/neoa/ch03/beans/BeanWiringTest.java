package org.neoa.ch03.beans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.neoa.ch03.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class BeanWiringTest {

    private AnnotationConfigApplicationContext context;

    @BeforeEach
    public void setup() {
        this.context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    }

    @Test
    public void contextReturnsBeansWiredUsingAutowireToInjectTheValuesThroughTheConstructor() {

        Person person = context.getBean(Person.class);

        assertThat(person).isNotNull();
        assertThat(person.getParrot()).isNotNull();
    }
}
