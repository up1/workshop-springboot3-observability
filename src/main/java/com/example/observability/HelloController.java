package com.example.observability;


import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @GetMapping("/hi")
    public String sayHi() {
        logger.info("Called sayHi");
        step1();
        try {
            String result = restTemplateBuilder.build().getForObject("http://localhost:8081/xyz", String.class);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return "Hello from spring boot 3";
    }

    @Observed(name = "user.name",
            contextualName = "getting-user-name",
            lowCardinalityKeyValues = {"userType", "userType2"})
    private void step1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
