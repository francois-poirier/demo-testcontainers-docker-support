package com.fpo.controller;

import com.fpo.BaseIntegrationTest;
import com.fpo.entity.User;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class UserControllerE2ETest extends BaseIntegrationTest {

    @Test
    void shouldReturnSavedUser() {
        // given
        JSONObject userDetailsRequestJson = new JSONObject();
        userDetailsRequestJson.put("firstName","John");
        userDetailsRequestJson.put("lastName","Wick");
        userDetailsRequestJson.put("email","john.wick@gmail.com");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> request =
                new HttpEntity<String>(userDetailsRequestJson.toString(), headers);

        // when
        ResponseEntity<User> createdUserDetailsEntity = testRestTemplate.postForEntity("/users", request, User.class);

        // then
        assertEquals(HttpStatus.CREATED, createdUserDetailsEntity.getStatusCode());
        assertNotNull(createdUserDetailsEntity.getBody());
    }
}
