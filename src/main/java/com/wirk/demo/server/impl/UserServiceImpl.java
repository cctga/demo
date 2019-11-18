package com.wirk.demo.server.impl;

import com.wirk.demo.mapper.UserMapper;
import com.wirk.demo.model.UserModel;
import com.wirk.demo.model.UserRepoModel;
import com.wirk.demo.repository.UserRepository;
import com.wirk.demo.server.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

  @Resource private UserRepository userRepository;
  @Resource
  private UserMapper userMapper;

  @Override
  public UserRepoModel findById(String userId) {
    return userRepository.findById(userId).orElse(null);
  }

  @Override
  public List<UserRepoModel> findAll() {
    return userRepository.findAll();
  }

  @Override
  public UserRepoModel save(UserRepoModel user) {
    return userRepository.save(user);
  }

  @Override
  public void delete(String userId) {
    userRepository.deleteById(userId);
  }

  @Override
  public Page<UserRepoModel> findAll(Pageable pageable) {
    return userRepository.findAll(pageable);
  }

  @Override
  public List<UserRepoModel> findByName(String username) {
    return userRepository.findByUserName(username);
  }

  @Override
  public List<UserRepoModel> findByNameLike(String username) {
    return userRepository.findByUserNameLike(username);
  }

  @Override
  public List<UserRepoModel> findByUserIdIn(String[] ids) {
    return userRepository.findByUserIdIn(ids);
  }

  @Override
  public UserModel findByNameAndPwd(String name, String pwd) {
    return userMapper.findByNameAndPwd(name, pwd);
  }
}
