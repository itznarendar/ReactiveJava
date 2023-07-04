package com.example.reactiveDemo.fluxandmono;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class FluxAndMonoController {
	@GetMapping("/flux")
	public Flux<Integer> getFlux(){
	return Flux.just(1,2,3,4).delayElements(Duration.ofSeconds(1)).log();
	}
	@SuppressWarnings("deprecation")
	@GetMapping(value="/fluxstream",produces =MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Long> getFluxStream(){
	//return Flux.just(1,2,3,4).delayElements(Duration.ofSeconds(1)).log();
		return Flux.interval(Duration.ofSeconds(1)).log();
	}
}
