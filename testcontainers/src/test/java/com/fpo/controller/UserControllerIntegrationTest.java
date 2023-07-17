package com.fpo.controller;

import com.fpo.BaseIntegrationTest;
import com.fpo.entity.User;
import org.junit.jupiter.api.Test;


public class UserControllerIntegrationTest  extends BaseIntegrationTest {

    @Test
    void shouldReturnSavedUser() {
        // given
        var user = new User("John", "Wick", "john.wick@gmail.com");
        userRepository.save(user);

        // when

        // then
    }
}
