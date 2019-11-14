package com.wirk.demo.repository;

import com.wirk.demo.model.UserRepoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserRepoModel, String> {

  List<UserRepoModel> findByUserName(String username);

  List<UserRepoModel> findByUserNameLike(String username);

  List<UserRepoModel> findByUserIdIn(String[] ids);
}
