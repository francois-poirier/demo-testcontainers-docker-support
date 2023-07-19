package com.fpo;

import com.fpo.config.TestContainersConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(TestContainersConfiguration.class)
class ApplicationContextContainerTest {

    @Test
    void contextLoads(){

    }
}
