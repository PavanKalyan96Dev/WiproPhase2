package com.wipro.controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactive")
public class ReactiveController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Hello, Reactive World!");
    }

    @GetMapping("/numbers")
    public Flux<Integer> numbers() {
        return Flux.range(1, 5); // Returns numbers from 1 to 5
    }
}
