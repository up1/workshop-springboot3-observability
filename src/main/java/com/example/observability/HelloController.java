package com.example.observability;


import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
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
    private RestTemplate restTemplate;

    @Autowired
    private MeterRegistry meterRegistry;

    @Autowired
    private HelloService helloService;

    @GetMapping("/hi")
    public String sayHi() {
        logger.info("Called sayHi");
        helloService.step1();
        try {
            String result = restTemplate.getForObject("http://localhost:8081/xyz", String.class);
        }catch (Exception e) {
            e.printStackTrace();
        }

        Counter counter = Counter
                .builder("hello-springboot")
                .description("Success case")
                .tag("result", "success")
                .register(meterRegistry);
        counter.increment();

        return "Hello from spring boot 3";
    }

}
