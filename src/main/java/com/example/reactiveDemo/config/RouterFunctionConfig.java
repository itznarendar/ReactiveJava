package com.example.reactiveDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.reactiveDemo.handler.SampleHandlerFunction;

@Configuration
public class RouterFunctionConfig {
    @Bean
	public RouterFunction<ServerResponse> getRouter(SampleHandlerFunction handlerFunction) {
		return RouterFunctions.route().GET("/functional/flux",RequestPredicates.accept(MediaType.APPLICATION_JSON), handlerFunction::getFlux).build();
		
	}
}
