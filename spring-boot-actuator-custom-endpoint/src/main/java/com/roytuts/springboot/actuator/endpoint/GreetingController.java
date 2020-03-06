package com.roytuts.springboot.actuator.endpoint;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roytuts.springboot.actuator.vo.Greeting;

@Component
@ControllerEndpoint(id = "controller-endpoint")
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@ResponseBody
	@GetMapping("/hello")
	public Greeting greet(@RequestParam(defaultValue = "Stranger") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}