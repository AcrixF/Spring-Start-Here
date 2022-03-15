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
    void contextReturnsExpectedBeanWhenUsingComponentStereotypeAnnotation() {
        Parrot parrot = context.getBean("parrot", Parrot.class);
        assertThat(parrot).isNotNull()
                .isExactlyInstanceOf(Parrot.class)
                .hasFieldOrPropertyWithValue("name", "Kiki");
    }
}
