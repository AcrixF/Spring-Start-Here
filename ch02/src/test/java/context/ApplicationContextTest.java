package context;

import config.ProjectConfig;
import model.Parrot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextTest {

    private AnnotationConfigApplicationContext context;

    @BeforeEach
    public void setup() {
        context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    }

   @Test
    public void contextThrowsAnExceptionWhenMultipleBeansOfTheSameInstance() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> context.getBean(Parrot.class));
   }

   @Test
    public void contextReturnsExpectedBeanWhenInstanceAndNameAreProvided() {
        Parrot miki = context.getBean("parrot2", Parrot.class);
        assertThat(miki).isNotNull()
                .isExactlyInstanceOf(Parrot.class)
                .hasFieldOrPropertyWithValue("name", "Miki");
   }

}
