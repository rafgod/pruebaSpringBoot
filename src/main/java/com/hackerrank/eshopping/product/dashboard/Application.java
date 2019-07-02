package com.hackerrank.eshopping.product.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories("com.hackerrank.eshopping.product.dashboard.repositories")
public class Application {
    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }
}
