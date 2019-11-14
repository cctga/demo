package com.wirk.demo.quartz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * @author : Mao LuDong
 * @date : Created in 11:14 2019/11/14
 */
@Configuration
@EnableScheduling
public class SendMailQuartz {

  private final Logger logger = LogManager.getLogger(this.getClass());

  @Scheduled(cron = "0 0/1 * * * ?")
  public void run1(){
    logger.info("定时器执行了！");
  }

}
