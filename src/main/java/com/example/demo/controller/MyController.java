package com.example.demo.controller;

import com.example.demo.pojo.Product;
import com.example.demo.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class MyController {
    @RequestMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable(name = "name") String username) {
        return "hello world!" + username;
    }

    public static void main(String[] args) {

        SpringApplication.run(MyController.class, args);
    }

    @Autowired
    HttpServletRequest request;
    @RequestMapping("/testjsp")
    public String tojsp(){
        request.setAttribute("test","我的jsp测试！");
        return "/index";
    }

    @RequestMapping("/thymeleaf")
    public ModelAndView thymeleaf(){
        ModelAndView mad = new ModelAndView();
        List<Product> products = new ArrayList<>();
        products.add(new Product("apple",11.0f));
        products.add(new Product("pear",11.0f));
        products.add(new Product("banana",11.0f));
        mad.addObject("allProducts",products);
        mad.setViewName("/thymeleaf.html");
        return mad;
    }

    @Autowired
    UserDao userDao;

    @RequestMapping("/testSource")
    @ResponseBody
    public String getConnection() throws SQLException {
        return userDao.getConnection().toString();
    }
}
