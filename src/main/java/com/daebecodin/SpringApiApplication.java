package com.daebecodin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController//allows me to create rest api
public class  SpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringApiApplication.class, args);
    }

    @GetMapping//lts me expose the method as a rest endpoint
    public String helloWorld() {
        return "Hello World";
    }
}
