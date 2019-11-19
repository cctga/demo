package com.wirk.demo.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MoodConsumer {

  @JmsListener(destination = "user.queue")
  public void receiveQueue(String text) {
    System.out.println("用户发表了说说:" + text);
  }
}
