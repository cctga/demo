package com.wirk.demo.server.impl;

import com.wirk.demo.model.MoodRepoModel;
import com.wirk.demo.repository.MoodRepository;
import com.wirk.demo.server.MoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("moodService")
public class MoodServiceImpl implements MoodService {

  @Resource private MoodRepository moodRepository;

  @Override
  public MoodRepoModel save(MoodRepoModel mood) {
    return moodRepository.save(mood);
  }
}
