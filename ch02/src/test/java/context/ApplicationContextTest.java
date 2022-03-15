package context;

import config.ProjectConfig;
import model.Parrot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextTest {

    private AnnotationConfigApplicationContext context;

    @BeforeEach
    public void setup() {
        context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    }

    @Test
    void contextReturnsExpectedBeanWhenUsingRegisterBeanMethod() {

        context.registerBean("parrot1",
                Parrot.class,
                () -> Parrot.builder().name("Kiki").build(),
                beanDefinition -> beanDefinition.setPrimary(true));

        Parrot parrot = context.getBean(Parrot.class);

        assertThat(parrot).isNotNull()
                .isExactlyInstanceOf(Parrot.class)
                .hasFieldOrPropertyWithValue("name", "Kiki");
    }
}
