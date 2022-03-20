package org.neoa.ch03.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Person {

    private String name = "Marlen";
    private final Parrot parrot;

    @Autowired
    public Person(Parrot miki) {
        this.parrot = miki;
    }
}
