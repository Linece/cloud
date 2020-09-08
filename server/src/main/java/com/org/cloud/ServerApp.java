package com.org.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class ServerApp {
  public static void main(String[] args) {
	  new SpringApplicationBuilder(ServerApp.class).run(args);
  }
}
