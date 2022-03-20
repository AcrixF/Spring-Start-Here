package org.neoa.ch03.beans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.neoa.ch03.config.ProjectConfig;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BeanWiringTest {

    private AnnotationConfigApplicationContext context;

    @BeforeEach
    public void setup() {
        this.context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    }

    @Test
    public void springContextReturnsBeanThatWhichNameMatchesTheOneSpecifiedInTheParamMethod() {
        Person person = context.getBean(Person.class);

        assertThat(person).isNotNull()
                .satisfies(p -> {
                   assertThat(p.getName()).isNotEmpty()
                           .isEqualTo("Marlen");
                   assertThat(p.getParrot())
                           .isNotNull()
                           .hasFieldOrPropertyWithValue("name", "Miki");
                });
    }
}
