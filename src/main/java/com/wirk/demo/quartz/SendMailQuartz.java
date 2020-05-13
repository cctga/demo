package com.wirk.demo.quartz;

import com.wirk.demo.mail.SendJunkMailService;
import com.wirk.demo.model.UserRepoModel;
import com.wirk.demo.server.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.List;


/**
 * @author : Mao LuDong
 * @date : Created in 11:14 2019/11/14
 */
//@Configuration
//@EnableScheduling
public class SendMailQuartz {

  private final Logger logger = LogManager.getLogger(this.getClass());

  @Resource
  private SendJunkMailService sendJunkMailService;

  @Resource
  private UserService userService;

//  @Scheduled(cron = "0/5 * * * * ?")
  public void run1() throws MessagingException {
    List<UserRepoModel> all = userService.findAll();
    logger.info("定时器给所有用户发送邮件！");
    boolean b = sendJunkMailService.sendJunkMail(all);
    if(b){
      logger.info("邮件发送成功！");
    }else{
      logger.info("邮件发送失败！");
    }
  }

}
