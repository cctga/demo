package com.wirk.demo;

import com.wirk.demo.model.UserModel;
import com.wirk.demo.model.UserRepoModel;
import com.wirk.demo.server.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {

  @Resource private JdbcTemplate jdbcTemplate;

  @Resource private UserService userService;

  @Resource private RedisTemplate rt;

  @Resource private StringRedisTemplate srt;

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
}
