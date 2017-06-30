package com.cht.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

//POJO
@Path("hello")
public class HelloService {
	@Path("chthello")
	@GET
	@Produces("application/json") // MIME Type
	public String helloWorld() {
		//return "<font size=5>Hello World/大家好!!</font>";
		return "{\"message\":\"Hello World/大家好!!\"}";
	}
}
