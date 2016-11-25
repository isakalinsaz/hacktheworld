package com.service.restfull;


import com.service.config.SpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SpringConfig springConfig;

    @Override
    public String sayMyName() {
        return "Hello World " + springConfig.getUsername();
    }
}
