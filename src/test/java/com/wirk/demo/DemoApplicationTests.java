package com.wirk.demo;

import com.wirk.demo.activemq.MoodProducer;
import com.wirk.demo.config.async.ExecutePoolConfig;
import com.wirk.demo.model.MoodRepoModel;
import com.wirk.demo.model.UserModel;
import com.wirk.demo.model.UserRepoModel;
import com.wirk.demo.server.MoodService;
import com.wirk.demo.server.UserService;
import com.wirk.demo.util.SnowflakeIdWorker;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {

  @Resource private ExecutePoolConfig executePoolConfig;

  @Resource private JdbcTemplate jdbcTemplate;

  @Resource private UserService userService;

  @Resource private MoodService moodService;

  @Resource private SnowflakeIdWorker snowflakeIdWorker;

  @Resource private RedisTemplate redisTemplate;

  @Resource private StringRedisTemplate stringRedisTemplate;

  @Resource private MoodProducer moodProducer;

  @Test
  void contextLoads() {}

  @Test
  void mysqlTest() {
    String sql = "select user_id,username,pwd,email from user";
    List<UserModel> userList =
        jdbcTemplate.query(
            sql,
            (resultSet, i) -> {
              UserModel data = new UserModel();
              data.setUserId(resultSet.getString("user_id"));
              data.setUsername(resultSet.getString("username"));
              data.setPwd(resultSet.getString("pwd"));
              data.setEmail(resultSet.getString("email"));
              return data;
            });
    System.out.println("查询成功!");
    for (UserModel userModel : userList) {
      System.out.println(
          String.format(
              "[id] %s,[name] %s,[pwd] %s,[email] %s",
              userModel.getUserId(),
              userModel.getUsername(),
              userModel.getPwd(),
              userModel.getEmail()));
    }
  }

  @Test
  void testRepository() {
    List<UserRepoModel> all = userService.findAll();
    System.out.println(all);
    PageRequest pr = PageRequest.of(0, 10);
    Page<UserRepoModel> all1 = userService.findAll(pr);
    System.out.println(all1);
    System.out.println(all1.get().collect(Collectors.toList()));
    List<UserRepoModel> es = userService.findByNameLike("%est%");
    System.out.println(es);
  }

  @Test
  void testExecuter(){
    System.out.println(executePoolConfig);
  }

  @Test
  void testRepository2(){
    MoodRepoModel mood = new MoodRepoModel();
    mood.setId(String.valueOf(snowflakeIdWorker.nextId()));
    mood.setUserId("11");
    mood.setContent("今天的第一条说说.");
    mood.setPraiseNum("0");
    mood.setPublishTime("2019-11-18 22:01:23");
    MoodRepoModel save = moodService.save(mood);
    System.out.println(save);
  }

  @Test
  void testActiveMq(){
    Destination activeMQQueue = new ActiveMQQueue("user.queue");
    moodProducer.sendMessage(activeMQQueue,"hello,mq!");
  }
}
