package com.org.gatway.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GateWayController {

	@GetMapping("/stuff")
	public String stuff(){
		return "stuff";
	}
}
