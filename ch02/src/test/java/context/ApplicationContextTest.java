package context;

import config.ProjectConfig;
import model.Parrot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextTest {

    private AnnotationConfigApplicationContext context;

    @BeforeEach
    public void setup() {
        context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    }
    @Test
    void contextReturnsExpectedBeanWhenInstanceAndNameAreProvided() {
        Parrot moko = context.getBean("parrot4", Parrot.class);
        assertThat(moko).isNotNull()
                .isExactlyInstanceOf(Parrot.class)
                .hasFieldOrPropertyWithValue("name", "Moko");
    }

    @Test
    void contextReturnsExpectedBeansWhenUsingBeanNames() {
       Parrot koko = context.getBean("Koko", Parrot.class);
       Parrot miki = context.getBean("Miki", Parrot.class);
       Parrot riki = context.getBean("Riki", Parrot.class);

       assertThat(koko).isNotNull();
       assertThat(miki).isNotNull();
       assertThat(riki).isNotNull();
    }

    @Test
    void contextReturnsBeanMarkedAsPrimaryWhenNoBeanNameProvided() {
        Parrot parrot = context.getBean(Parrot.class);
        assertThat(parrot).isNotNull()
                .isExactlyInstanceOf(Parrot.class)
                .hasFieldOrPropertyWithValue("name", "Riki");
   }

}
