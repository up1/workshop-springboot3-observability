package com.example.observability;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DemoService{
    public String getData() {
        return "Hello" + new Random().nextInt(10);
    }
}

