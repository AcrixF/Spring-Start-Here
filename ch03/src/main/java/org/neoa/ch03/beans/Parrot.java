package org.neoa.ch03.beans;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Log
@Component
public class Parrot {

    private String name = "Koko";

    private final Person person;

    @Autowired
    public Parrot(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Parrot : " + name;
    }
}
