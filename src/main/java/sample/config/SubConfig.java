package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sample.model.Data;

import java.util.Collections;
import java.util.List;

@Configuration
public class SubConfig {
//    @Bean
//    Data data3() {
//        return new Data("data3");
//    }

    @Bean
    List<Data> dataList() {
        return Collections.singletonList(new Data("data100"));
    }

    @Bean
    List<Data> dataList2() {
        return Collections.singletonList(new Data("data200"));
    }
}
