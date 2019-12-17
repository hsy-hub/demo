package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class MyController {
    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable(name="name") String username){
        return "hello world!"+username;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyController.class,args);
    }
}
