package com.wirk.demo.activemq;

import com.wirk.demo.enums.ActMQQueueEnum;
import com.wirk.demo.model.MoodRepoModel;
import com.wirk.demo.server.MoodService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MoodConsumer {

  @Resource private MoodService moodService;

  @JmsListener(destination = "user.queue")
  public void receiveQueue(String text) {
    System.out.println("用户发表了说说:" + text);
  }

  @JmsListener(destination = "user.async.save")
  public void asyncSave(MoodRepoModel mood){
    System.out.println("发表了说说");
    System.out.println(mood);
    moodService.save(mood);
  }
}
