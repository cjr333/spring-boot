package sample.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuples;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class SampleService {
    public Mono<String> log() {
        return Mono.just("success")
                .flatMap(s -> Mono.subscriberContext().map(ctx -> Tuples.of(s, ctx)))
                .flatMap(t2 -> {
                    System.out.println(t2.getT2());
                    return ThreadLocalRandom.current().nextBoolean() ? Mono.just(t2.getT1()) : Mono.error(new RuntimeException("test error"));
                });
//                .doOnError(throwable -> Mono.subscriberContext().subscribe(ctx -> System.out.println(ctx.get("request").toString())));
//                .onErrorMap(throwable -> Mono.subscriberContext().map(ctx -> {
//                    System.out.println(ctx.get("request").toString());
//                    return throwable;
//                }));
    }
}
