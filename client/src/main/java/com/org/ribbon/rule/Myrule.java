package com.org.ribbon.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

public class Myrule extends AbstractLoadBalancerRule {

	private ILoadBalancer lb;

	public Myrule(){}


	@Override
	public void initWithNiwsConfig(IClientConfig iClientConfig) {

	}

	@Override
	public Server choose(Object o) {
		ILoadBalancer lb = getLoadBalancer();
		List<Server> servers = lb.getAllServers();
		Random r = new Random();
		int rule = r.nextInt(10);
		if(rule > 7){
			System.out.println("port:"+8020);
			return getServers(servers, 8020);
		}
		System.out.println("port:"+8021);
		return getServers(servers, 8021);
	}

	private Server getServers(List<Server> server,int port){
		for(Server s:server){
			if(s.getPort() == port){
				return s;
			}

		}
		return null;
	}

	@Override
	public ILoadBalancer getLoadBalancer() {
		// TODO Auto-generated method stub
		return this.lb;
	}

	@Override
	public void setLoadBalancer(ILoadBalancer lb) {
		// TODO Auto-generated method stub
		this.lb = lb;
	}
}
