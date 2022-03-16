package org.neoa.ch03.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Log
@Builder
@Component
public class Parrot {

    private String name;

    @Override
    public String toString() {
        return "Parrot : " + name;
    }
}
