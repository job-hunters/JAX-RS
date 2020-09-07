package com.demo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("demo")
public class HelloWorld {

	@Path("say-hello")
	@GET
	public String sayHello() {
		return "Hello from the Server!";
	}
}
