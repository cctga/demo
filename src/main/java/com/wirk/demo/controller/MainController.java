package com.wirk.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
@RequestMapping("/main")
public class MainController {

  @RequestMapping("/paramsError")
  public String paramsError(HttpServletRequest req, Model model){
    model.addAttribute("params",req.getParameterMap());
    return "/main/params-error";
  }
}
