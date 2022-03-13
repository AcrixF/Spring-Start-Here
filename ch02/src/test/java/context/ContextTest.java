package context;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ContextTest {

    @Test
    public void springContextIsAdded() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        assertThat(annotationConfigApplicationContext).isNotNull();
    }


}
