package com.wirk.demo.repository;

import com.wirk.demo.model.MoodRepoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoodRepository extends JpaRepository<MoodRepoModel, String> {

  MoodRepoModel save(MoodRepoModel mood);
}
