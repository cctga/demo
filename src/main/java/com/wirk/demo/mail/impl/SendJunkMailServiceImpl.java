package com.wirk.demo.mail.impl;

import com.wirk.demo.async.AsyncTask;
import com.wirk.demo.mail.SendJunkMailService;
import com.wirk.demo.model.UserRepoModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.List;

/**
 * @author : Mao LuDong
 * @date : Created in 10:35 2019/11/15
 */
@Service("sendJunkMailService")
public class SendJunkMailServiceImpl implements SendJunkMailService {

  public static final Logger logger = LogManager.getLogger(SendJunkMailServiceImpl.class);

  @Resource
  private AsyncTask asyncTask;

  @Override
  public boolean sendJunkMail(List<UserRepoModel> userList) {
    if (userList == null || userList.size() < 1) {
      return false;
    }
    try {
      for (UserRepoModel user : userList) {
        asyncTask.sendMailTask(user);
      }
      return true;
    } catch (MessagingException | MailException e) {
      e.printStackTrace();
      return false;
    }
  }
}
