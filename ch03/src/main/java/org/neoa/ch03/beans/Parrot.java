package org.neoa.ch03.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@Log
@Builder
@Component
public class Parrot {

    private String name;

    public Parrot() {
       log.info("Parrot created.");
    }

    @Override
    public String toString() {
        return "Parrot : " + name;
    }
}
