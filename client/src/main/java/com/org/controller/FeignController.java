package com.org.controller;

import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.niws.client.http.RestClient;
import com.org.clinet.StoreClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

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
			RestClient client = (RestClient) ClientFactory.getNamedClient("stores");
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

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/stuff")
	public void doStuff() throws Exception{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		for (int i=0;i<10;i++){
			ServiceInstance instance = loadBalancerClient.choose("stores");
			URI storesUri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort())+"/cloud");

			HttpGet httpGet = new HttpGet(storesUri);
			org.apache.http.HttpResponse response =  httpClient.execute(httpGet);
			System.out.println(EntityUtils.toString(response.getEntity()));
		}

	}

//	@GetMapping("/router")
//	public String router(){
//		return restTemplate.getForObject("http://provider/student/index",String.class);
//
//	}
}
