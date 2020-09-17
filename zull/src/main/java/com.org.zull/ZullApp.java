package com.org.zull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZullApp {
  public static void main(String[] args) {
	  SpringApplication.run(ZullApp.class,args);
  }
}
