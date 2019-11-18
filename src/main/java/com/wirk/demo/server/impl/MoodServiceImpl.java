package com.wirk.demo.server.impl;

import com.wirk.demo.model.MoodRepoModel;
import com.wirk.demo.repository.MoodRepository;
import com.wirk.demo.server.MoodService;

import javax.annotation.Resource;

public class MoodServiceImpl implements MoodService {

  @Resource private MoodRepository moodRepository;

  @Override
  public MoodRepoModel save(MoodRepoModel mood) {
    return moodRepository.save(mood);
  }
}
