package com.org.config;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.org.ribbon.rule.Myrule;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 代码优先于配置文件
 */

@Configuration
public class RibbonConfig {
//	public LoadBalancerClient loadBalancerClient(){
//		SpringClientFactory springClientFactory = new SpringClientFactory();
//		springClientFactory.getClientConfig("");
//
//
//		LoadBalancerClient loadBalancerClient = new RibbonLoadBalancerClient(springClientFactory);
//		return loadBalancerClient;
//	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	/**
	 * 轮询规则
	 * @return
	 */
//	@Bean
//	public IRule roundRule(){
//		return new RoundRobinRule();
//	}

	/**
	 * 随机规则
	 * @return
	 */
//	@Bean
//	public IRule randRule(){
//		return new RandomRule();
//	}

	/**
	 * 自定义规则
	 */
	@Bean
	public IRule myRule(){
		return new Myrule();
	}
}
