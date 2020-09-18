package sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import reactor.core.publisher.Hooks;
import sample.model.Data;
import sample.service.DataService;

import javax.annotation.PostConstruct;
import java.util.List;

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

  @Autowired
  List<Data> dataList;

//  @Bean
//  Data data1() {
//    return new Data("data1");
//  }
//
//  @Bean
//  Data data2() {
//    return new Data("data2");
//  }

  @Bean
  DataService dataService() {
    return new DataService(dataList);
  }
}
