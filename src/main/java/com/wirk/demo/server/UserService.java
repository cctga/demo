package com.wirk.demo.server;

import com.wirk.demo.model.UserRepoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
  UserRepoModel findById(String userId);
  List<UserRepoModel> findAll();
  UserRepoModel save(UserRepoModel user);
  void delete(String userId);
  Page<UserRepoModel> findAll(Pageable pageable);

  List<UserRepoModel> findByName(String name);
  List<UserRepoModel> findByNameLike(String name);
  List<UserRepoModel> findByUserIdIn(String[] ids);

}
