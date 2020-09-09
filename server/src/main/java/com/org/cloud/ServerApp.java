package com.org.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;


@SpringBootApplication
@EnableEurekaClient
public class ServerApp {
  public static void main(String[] args) {

    new SpringApplicationBuilder(ServerApp.class).run(args);
//    	  Scanner scanner = new Scanner(System.in);
//    	  String port = scanner.nextLine();
//    new SpringApplicationBuilder(ServerApp.class)
//        .properties("server.port=8021", "spring.application.name=server2")
//        .run(args);
  }
}
