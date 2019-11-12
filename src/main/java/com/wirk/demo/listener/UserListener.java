package com.wirk.demo.listener;

import com.wirk.demo.model.UserRepoModel;
import com.wirk.demo.server.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class UserListener implements ServletContextListener {

  private Logger logger = LogManager.getLogger(this.getClass());

  @Resource private RedisTemplate<String, UserRepoModel> redisTemplate;

  @Resource private UserService userService;

  private static final String ALL_USER = "ALL_USER_LIST";

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    logger.debug("项目初始化");
    logger.debug("用户Redis的缓存");
    List<UserRepoModel> allUser = userService.findAll();
    redisTemplate.opsForList().leftPushAll(ALL_USER, allUser);
    List<UserRepoModel> range = redisTemplate.opsForList().range(ALL_USER, 0, -1);
    System.out.println(range);
//    redisTemplate.delete(ALL_USER);
    logger.debug(sce);
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    logger.debug("项目结束");
    logger.debug(sce);
  }
}
