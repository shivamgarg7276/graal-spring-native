package com.example.graal.restserver.main;

import com.example.graal.restserver.config.GithubProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.graal.restserver")
@EnableConfigurationProperties(GithubProperties.class)
public class RestApplicationWithAOT {

  public static void main(String[] args) {
    SpringApplication.run(RestApplicationWithAOT.class, args);
  }
}
