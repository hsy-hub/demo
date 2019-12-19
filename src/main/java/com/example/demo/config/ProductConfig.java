package com.example.demo.config;

import com.example.demo.pojo.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    private Product product;
    @Bean(name="product")
    public Product initProduct(){
        product = new Product();
        product.setName("aaa");
        product.setPrice(100f);
        return product;
    }
}
