package com.auliahanifan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.auliahanifan.*")
@EnableJpaRepositories(basePackages = "com.auliahanifan.*")
@EntityScan(basePackages = {"com.auliahanifan.*"}) // enable entity migration in other module
public class DemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}
