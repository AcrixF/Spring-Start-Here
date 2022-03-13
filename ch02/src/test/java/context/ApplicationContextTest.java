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
   void contextThrowsAnExceptionWhenMultipleBeansOfTheSameInstance() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> context.getBean(Parrot.class));
   }

   @Test
   void contextReturnsExpectedBeanWhenInstanceAndNameAreProvided() {
        Parrot miki = context.getBean("parrot4", Parrot.class);
        assertThat(miki).isNotNull()
                .isExactlyInstanceOf(Parrot.class)
                .hasFieldOrPropertyWithValue("name", "Miki");
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

}
