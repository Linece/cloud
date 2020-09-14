package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import java.net.URI;

public class MyClass {

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	public void doStuff(){
		ServiceInstance instance = loadBalancerClient.choose("stores");
		URI storesUri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));

	}
}
