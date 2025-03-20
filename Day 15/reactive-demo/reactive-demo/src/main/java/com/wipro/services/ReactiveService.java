package com.wipro.services;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveService {

    public Mono<String> getMonoData() {
        return Mono.just("Single Data Response");
    }

    public Flux<String> getFluxData() {
        return Flux.just("Item1", "Item2", "Item3", "Item4");
    }
}
