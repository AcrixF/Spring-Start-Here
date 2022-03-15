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
    public Person person() {
        Person person = new Person();
        person.setName("Ella");
        person.setParrot(miki());
        return person;
    }

    @Bean
    public Parrot miki() {
        Parrot miki = new Parrot();
        miki.setName("Miki");
        return miki;
    }
}
