package io.szak.springcms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("io.szak")
@SpringBootApplication
public class SpringCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCmsApplication.class, args);
    }
}
