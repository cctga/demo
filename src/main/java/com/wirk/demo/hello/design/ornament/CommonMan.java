package com.wirk.demo.hello.design.ornament;

/**
 * 被装饰器
 * @author : Mao LuDong
 * @date : Created in 14:15 2019/12/2
 */
public class CommonMan implements Man {
  @Override
  public void action(){
    System.out.println("我会跑步！");
  }
}
