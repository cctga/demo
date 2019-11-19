package com.wirk.demo.config.amqueue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Destination;


@Configuration
public class AmQueueConfig {

  @Bean(name = "amUserQueue")
  public Destination amUserQueue(){
    return new ActiveMQQueue("user.queue");
  }

  @Bean(name = "amAsyncSaveOfMood")
  public Destination amAsyncSaveOfMood(){
    return new ActiveMQQueue("user.async.save");
  }
}
