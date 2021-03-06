package com.org.zull.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Zuul过滤器，必须继承ZuulFilter父类。
 * 当前类型的对象必须交由Spring容器管理。使用@Component注解描述。
 * 继承父类后，必须实现父类中定义的4个抽象方法。
 * shouldFilter、 run、 filterType、 filterOrder
 */
@Component
public class Myfilter extends ZuulFilter {


	/**
	 * 过滤器的类型。可选值有：
	 * pre - 前置过滤
	 * route - 路由后过滤
	 * error - 异常过滤
	 * post - 远程服务调用后过滤
	 */

	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 同种类的过滤器的执行顺序。
	 * 按照返回值的自然升序执行。
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * 返回boolean类型。代表当前filter是否生效。
	 * 默认值为false。
	 * 返回true代表开启filter。
	 */
	@Override
	public boolean shouldFilter() {
		return false;
	}
	/**
	 * run方法就是过滤器的具体逻辑。
	 * return 可以返回任意的对象，当前实现忽略。（spring-cloud-zuul官方解释）
	 * 直接返回null即可。
	 */
	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:"+request.getRequestURL());
		return null;
	}
}
