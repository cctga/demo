package com.wirk.demo.repository;

import com.wirk.demo.model.UserRepoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserRepoModel, String> {

  List<UserRepoModel> findByUsername(String username);

  List<UserRepoModel> findByUsernameLike(String username);

  List<UserRepoModel> findByUserIdIn(String[] ids);
}
