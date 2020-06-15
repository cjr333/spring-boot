package sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@RestController
public class SampleController {
  @GetMapping("/sample")
  public Mono<List<Integer>> sample() {
    return Mono.just(Collections.singletonList(1));
  }
}
