package com.inccrativ.herokujava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/student")
public class TestController {
    
    @GetMapping("/hello")
	public String hello(){
		return "Hello world";
	} 

}
