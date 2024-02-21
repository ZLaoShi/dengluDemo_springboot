package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class MyProjectBackendApplicationTests {

    @Test
    void GeneratePassword() {
        String password = "123456";

        System.out.println(new BCryptPasswordEncoder().encode(password));
    }
}
