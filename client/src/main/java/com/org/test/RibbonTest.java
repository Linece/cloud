package com.org.test;

import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.niws.client.http.RestClient;
import org.apache.http.util.EntityUtils;
import org.springframework.cloud.netflix.ribbon.RibbonClientHttpRequestFactory;
import org.springframework.cloud.netflix.ribbon.apache.RibbonApacheHttpRequest;
import org.springframework.cloud.netflix.ribbon.apache.RibbonApacheHttpResponse;
import org.springframework.cloud.netflix.ribbon.apache.RibbonLoadBalancingHttpClient;
import org.springframework.cloud.netflix.ribbon.okhttp.OkHttpLoadBalancingClient;
import org.springframework.cloud.netflix.ribbon.support.RibbonCommandContext;
import org.springframework.http.client.ClientHttpRequestFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

public class RibbonTest {
  public static void main(String[] args) throws Exception{
	  ConfigurationManager.getConfigInstance().setProperty(
			  "sample.ribbon.listOfServers", "localhost:8020,localhost:8021"); // 5
	  System.out.println(ConfigurationManager.getConfigInstance().getProperty("sample-client.ribbon.listOfServers"));

	  RestClient client = (RestClient) ClientFactory.getNamedClient("sample");
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
  }
}
