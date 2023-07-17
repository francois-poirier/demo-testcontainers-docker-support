package com.fpo;

import com.fpo.config.TestContainersConfiguration;
import com.fpo.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestContainersConfiguration.class)
@ActiveProfiles("test")
public class BaseIntegrationTest {

    @Autowired
    protected TestRestTemplate testRestTemplate;

    @Autowired
    protected UserRepository userRepository;

    @AfterEach
    void cleanup() {
        userRepository.deleteAll();
    }
}
