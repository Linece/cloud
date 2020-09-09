package com.org.controller;

import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.loadbalancer.IRule;
import com.netflix.niws.client.http.RestClient;
import com.org.clinet.StoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@RestController
public class FeignController {

	@Autowired
	private StoreClient storeClient;


	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/getStore")
	public String getStore(){
		return storeClient.getStore();
	}


	@GetMapping("/getRibbon")
	public String ribbon(){
		try{
			RestClient client = (RestClient) ClientFactory.getNamedClient("sample-client");
			HttpRequest request = HttpRequest.newBuilder().uri("/cloud").build(); // 3
			for (int i = 0; i < 10; i++)  {
				HttpResponse response = client.executeWithLoadBalancer(request);
				InputStream in = response.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				String result = "";
				String line = null;
				if((line = reader.readLine())!= null){
					result += result+ line;
				}
				System.out.println(response.getRequestedURI()+"：@@@@@@@@@@@@@@@@@@:"+line);
			}
		}catch (Exception e){

		}
		return null;
	}
}
