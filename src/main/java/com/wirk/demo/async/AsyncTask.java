package com.wirk.demo.async;

import com.wirk.demo.model.UserRepoModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author : Mao LuDong
 * @date : Created in 15:13 2019/11/15
 */
@Component
public class AsyncTask {

  private static final Logger log = LogManager.getLogger(AsyncTask.class);

  @Resource private JavaMailSender javaMailSender;

  @Value("${spring.mail.username}")
  private String username;

//  @Async
  public void sendMailTask(UserRepoModel user) throws MessagingException {
    log.info("线程："+Thread.currentThread().getName()+"发送邮件给："+user.getUserName()+" 开始发送！");
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage);
    mmh.setFrom(username);
    mmh.setSubject("test");
    mmh.setText("测试好没有好。。。");
    mmh.setTo(user.getEmail());
    javaMailSender.send(mimeMessage);
    log.info("线程："+Thread.currentThread().getName()+"发送邮件给："+user.getUserName()+"成功！");
  }
}
