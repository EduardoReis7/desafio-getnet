package com.desafio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@RequestMapping("/helloWorld")
	public String HelloWorld() {
		return "Hello World";
	}
}