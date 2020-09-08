package com.org.clinet;

import com.org.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "server1")
public interface StoreClient {

	@RequestMapping(method = RequestMethod.GET, value = "/cloud",consumes = MediaType.APPLICATION_JSON_VALUE)
	String getStore();

}
