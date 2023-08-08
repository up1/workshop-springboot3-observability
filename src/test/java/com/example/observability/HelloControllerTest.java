package com.example.observability;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HelloControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    private DemoService demoService;

    @Test
    void sayHi2() {
        when(demoService.getData()).thenReturn("Hello5");
        HelloResponse result =
                restTemplate.getForObject("/hi2", HelloResponse.class);
        assertEquals("Hello5", result.getMessage());
    }
}