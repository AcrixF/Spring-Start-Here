package org.neoa.ch05.services;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Log
@Service
@Lazy
public class UserService {

    public UserService() {
        log.info("UserService Instance Created!");
    }
}
