package org.neoa.ch05.services;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Log
@Service
public class UserService {

    public UserService() {
        log.info("UserService Instance Created!");
    }
}
