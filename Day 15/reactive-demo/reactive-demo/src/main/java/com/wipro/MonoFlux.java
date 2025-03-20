package com.wipro;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

public class MonoFlux{
    public static void main(String[] args) {
    
       Mono<String> m = Mono.just("pavan").log();	//mono returns the single data
        m.subscribe(x -> System.out.println(x)); 

        Flux<String> f = Flux.just("pavan","prem","sreenu","bharathi").log(); //flux returns the multipe data
        f.subscribe(x -> System.out.println(x)); 
    }
}

/* commment the flux and run the mono

14:19:40.437 [main] INFO reactor.Mono.Just.1 -- | onSubscribe([Synchronous Fuseable] Operators.ScalarSubscription)
14:19:40.442 [main] INFO reactor.Mono.Just.1 -- | request(unbounded)
14:19:40.442 [main] INFO reactor.Mono.Just.1 -- | onNext(pavan)
pavan
14:19:40.443 [main] INFO reactor.Mono.Just.1 -- | onComplete()

*/
//remove all comments and run
/*
 14:22:18.499 [main] INFO reactor.Mono.Just.1 -- | onSubscribe([Synchronous Fuseable] Operators.ScalarSubscription)
14:22:18.507 [main] INFO reactor.Mono.Just.1 -- | request(unbounded)
14:22:18.508 [main] INFO reactor.Mono.Just.1 -- | onNext(pavan)
pavan
14:22:18.510 [main] INFO reactor.Mono.Just.1 -- | onComplete()
14:22:18.702 [main] INFO reactor.Flux.Array.2 -- | onSubscribe([Synchronous Fuseable] FluxArray.ArraySubscription)
14:22:18.702 [main] INFO reactor.Flux.Array.2 -- | request(unbounded)
14:22:18.702 [main] INFO reactor.Flux.Array.2 -- | onNext(pavan)
pavan
14:22:18.702 [main] INFO reactor.Flux.Array.2 -- | onNext(prem)
prem
14:22:18.703 [main] INFO reactor.Flux.Array.2 -- | onNext(sreenu)
sreenu
14:22:18.703 [main] INFO reactor.Flux.Array.2 -- | onNext(bharathi)
bharathi
14:22:18.703 [main] INFO reactor.Flux.Array.2 -- | onComplete()



*/