package com.example.reactiveDemo;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxAndMonoTest {
	//@Test
	public void fluxTest() {
		//log for onnext tracking
		Flux<String> stringFluxExc=Flux.just("Spring","springboot","reactive").concatWith(Flux.error(new RuntimeException("String flux error"))).log();
		stringFluxExc.subscribe(System.out::println,(e)->System.err.println(e));
		Flux<String> stringFlux=Flux.just("Spring","springboot","reactive").log();
		stringFlux.subscribe(System.out::println,(e)->System.err.println(e),()->System.out.println("completed"));

	}
	
	@Test
	public void fluxTestWithouError() {	
		Flux<String> stringFlux=Flux.just("Spring","springboot","reactive").log();
StepVerifier.create(stringFlux).expectNext("Spring")
.expectNext("springboot").expectNext("reactive").verifyComplete();
	}
	@Test
	public void fluxTestWitError() {	
		Flux<String> stringFlux=Flux.just("Spring","springboot","reactive").concatWith(Flux.error(new RuntimeException("String flux error"))).log();
StepVerifier.create(stringFlux).expectNext("Spring")
.expectNext("springboot").expectNext("reactive")
//.expectError(RuntimeException.class)
.expectErrorMessage("String flux error")
.verify();
	}
	@Test
	public void fluxTestSingleWitError() {	
		Flux<String> stringFlux=Flux.just("Spring","springboot","reactive").concatWith(Flux.error(new RuntimeException("String flux error"))).log();
StepVerifier.create(stringFlux).expectNext("Spring","springboot","reactive")

//.expectError(RuntimeException.class)
.expectErrorMessage("String flux error")
.verify();
	}
	@Test
	public void fluxTestCountWitError() {	
		Flux<String> stringFlux=Flux.just("Spring","springboot","reactive").concatWith(Flux.error(new RuntimeException("String flux error"))).log();
StepVerifier.create(stringFlux).expectNextCount(3)
.expectError(RuntimeException.class)
//.expectErrorMessage("String flux error")
.verify();
	}

}
