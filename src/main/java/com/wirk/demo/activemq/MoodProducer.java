package com.wirk.demo.activemq;

import com.wirk.demo.model.MoodRepoModel;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

@Service
public class MoodProducer {

  @Resource private JmsMessagingTemplate jmsMessagingTemplate;

  public void sendMessage(Destination destination, String message) {
    jmsMessagingTemplate.convertAndSend(destination, message);
  }

  public void sendMessage(Destination destination, MoodRepoModel mood) {
    jmsMessagingTemplate.convertAndSend(destination, mood);
  }
}
