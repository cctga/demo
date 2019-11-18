package com.wirk.demo.controller;

import com.wirk.demo.model.UserModel;
import com.wirk.demo.model.UserRepoModel;
import com.wirk.demo.server.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

  @Resource private UserService userService;

  @RequestMapping("/getAllUser")
  public String test(String name, Model model) {
    System.out.println("controller收到name:" + name);
    List<UserRepoModel> all = userService.findAll();
    model.addAttribute("users", all);
    model.addAttribute(all);
    return "user/user";
  }

  @RequestMapping("/getAnUser")
  @ResponseBody
  public UserModel test(String name, String pwd) {
    return userService.findByNameAndPwd(name, pwd);
  }
}
