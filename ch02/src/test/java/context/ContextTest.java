package context;

import config.ProjectConfig;
import model.Parrot;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ContextTest {

    @Test
    public void springContextIsInitializedCorrectly() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        assertThat(context).isNotNull();
    }

    @Test
    public void initializeSpringContextWithConfigurationClassAndReturnsExpectedParrotBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot parrot = context.getBean("parrot", Parrot.class);
        assertThat(parrot).isNotNull()
                .isExactlyInstanceOf(Parrot.class);
        assertThat(parrot.getName()).isEqualTo("Koko");
    }

    @Test
    public void initializeSpringContextReturnsDefinedBeansInConfigurationFile() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot = context.getBean("parrot", Parrot.class);
        String hello = context.getBean("hello", String.class);
        Integer ten = context.getBean("ten", Integer.class);

        assertThat(parrot).isNotNull()
                .isExactlyInstanceOf(Parrot.class)
                .hasFieldOrPropertyWithValue("name", "Koko");

        assertThat(hello).isNotNull()
                .isNotEmpty()
                .isEqualTo("Hello")
                .isInstanceOf(String.class);

        assertThat(ten).isNotNull()
                .isNotZero()
                .isEqualTo(10)
                .isInstanceOf(Integer.class);
    }

}
