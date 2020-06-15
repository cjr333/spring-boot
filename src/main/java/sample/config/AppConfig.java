package sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import reactor.core.publisher.Hooks;

import javax.annotation.PostConstruct;

@Configuration
public class AppConfig {
  @Configuration
  @Profile({"local", "alpha", "qa", "pre"})
  public static class HooksConfig {
    @PostConstruct
    public void init() {
      Hooks.onOperatorDebug();
    }
  }
}
