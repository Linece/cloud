package com.org.cloud.controller;

import com.org.cloud.common.BaseController;
import com.org.cloud.common.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController extends BaseController {

	@GetMapping("/cloud")
	public ResponseData cloud(){
		return success("hello cloud");
	}
}
