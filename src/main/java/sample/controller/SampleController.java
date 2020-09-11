package sample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import sample.service.SampleService;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SampleController {
  private final SampleService sampleService;

  @GetMapping("/sample")
  public Mono<List<Integer>> sample() {
    return Mono.just(Collections.singletonList(1));
  }

  @GetMapping("/log")
  public Mono<String> log() {
    return sampleService.log().subscriberContext(ctx -> ctx.put("request", "{request json}"));
  }
}
