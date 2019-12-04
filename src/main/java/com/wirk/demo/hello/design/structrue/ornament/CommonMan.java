package com.wirk.demo.hello.design.structrue.ornament;

/**
 * 被装饰类
 * @author : Mao LuDong
 * @date : Created in 14:15 2019/12/2
 */
public class CommonMan implements Man {
  @Override
  public void action(){
    System.out.println("我会跑步！");
  }
}
