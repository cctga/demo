package com.wirk.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Mao LuDong
 * @date : Created in 18:35 2020/5/13
 */
@Controller
@RequestMapping("sys")
public class ErrorController {

  @RequestMapping("404")
  public String to404(){
    return "sys/404";
  }

  @RequestMapping("400")
  public String to400(){
    return "sys/400";
  }

  @RequestMapping("401")
  public String to401(){
    return "sys/401";
  }

  @RequestMapping("500")
  public String to500(){
    return "sys/500";
  }
}
