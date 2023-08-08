package com.example.observability;

import io.micrometer.core.instrument.MeterRegistry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HelloController.class)
class HelloControllerMvcTestTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MeterRegistry meterRegistry;

    @MockBean
    private HelloService helloService;

    @MockBean
    private DemoService demoService;

//
//    @MockBean
//    private DemoService demoService;

    @Test
    @DisplayName("ทดสอบนะ")
    void sayHi2() throws Exception {
//        when(demoService.getData()).thenReturn("Hello5");
        mvc.perform(MockMvcRequestBuilders.get("/hi2"))
                .andExpect(status().isOk());
    }

}