package com.wirk.demo.server;

import com.wirk.demo.model.MoodRepoModel;

public interface MoodService {

  MoodRepoModel save(MoodRepoModel mood);
}
