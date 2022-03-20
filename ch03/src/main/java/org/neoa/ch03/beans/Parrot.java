package org.neoa.ch03.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Getter
@Setter
@Log
public class Parrot {

    private String name;

    @Override
    public String toString() {
        return "Parrot : " + name;
    }
}
