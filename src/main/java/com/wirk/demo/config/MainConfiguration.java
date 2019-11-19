package com.wirk.demo.config;

import com.wirk.demo.util.SnowflakeIdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans({
  @ComponentScan("com.wirk.demo.server.**.*"),
  @ComponentScan("com.wirk.demo" + ".controller.*")
})
public class MainConfiguration {

  @Bean
  public SnowflakeIdWorker snowflakeIdWorker(){
    return new SnowflakeIdWorker(0,0);
  }

}
