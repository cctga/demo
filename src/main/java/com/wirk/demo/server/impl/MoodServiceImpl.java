package com.wirk.demo.server.impl;

import com.wirk.demo.activemq.MoodProducer;
import com.wirk.demo.enums.ActMQQueueEnum;
import com.wirk.demo.model.MoodRepoModel;
import com.wirk.demo.repository.MoodRepository;
import com.wirk.demo.server.MoodService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("moodService")
public class MoodServiceImpl implements MoodService {

  @Resource private MoodRepository moodRepository;
  @Resource private MoodProducer moodProducer;

  @Override
  public MoodRepoModel save(MoodRepoModel mood) {
    return moodRepository.save(mood);
  }

  @Override
  public boolean asyncSave(MoodRepoModel mood) {
    moodProducer.sendMessage(new ActiveMQQueue(ActMQQueueEnum.ASYNC_SAVE.getDes()), mood);
    return true;
  }
}
