package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parrot {
    private String name;

    @PostConstruct
    public void init() {
        this.name = "Kiki";
    }
}
