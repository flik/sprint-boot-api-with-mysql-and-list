package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // (scanBasePackages={"hello.springboot"}) same as @Configuration @EnableAutoConfiguration @ComponentScan combined
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
