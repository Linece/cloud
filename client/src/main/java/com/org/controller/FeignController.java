package com.org.controller;

import com.org.clinet.StoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

	@Autowired
	private StoreClient storeClient;

	@GetMapping("/getStore")
	public String getStore(){
		return storeClient.getStore();
	}
}
