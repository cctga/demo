package com.wirk.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Mao LuDong
 * @date : Created in 18:18 2020/5/13
 */
@Controller
public class IndexController {

  @RequestMapping("/")
  public String paramsError() {
    return "index";
  }
}
