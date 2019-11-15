package com.wirk.demo.mail;

import com.wirk.demo.model.UserRepoModel;

import javax.mail.MessagingException;
import java.util.List;

/**
 * @author : Mao LuDong
 * @date : Created in 14:50 2019/11/14
 */
public interface SendJunkMailService {
  boolean sendJunkMail(List<UserRepoModel> userList) throws MessagingException;
}
