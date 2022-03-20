package org.neoa.ch03.config;

import org.neoa.ch03.beans.Parrot;
import org.neoa.ch03.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.neoa.ch03.beans")
public class ProjectConfig {

    @Bean
    public Parrot koko() {
        Parrot parrot = new Parrot();
        parrot.setName("Koko");
        return parrot;
    }

    @Bean
    public Parrot miki() {
        Parrot parrot = new Parrot();
        parrot.setName("Miki");
        return parrot;
    }

    @Bean
    public Person person(Parrot miki) {
        Person person = new Person();
        person.setName("Marlen");
        person.setParrot(miki);
        return person;
    }

}
