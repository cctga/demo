package com.wirk.demo.hello.design.structrue.ornament;

/**
 * 飞翔装饰器
 * @author : Mao LuDong
 * @date : Created in 21:07 2019/12/3
 */
public class CommonWrapperFlyMan extends CommonWrapperMan {

  public CommonWrapperFlyMan(Man man) {
    super(man);
  }

  @Override
  public void action() {
    super.action();
    fly();
  }

  private void fly() {
    System.out.println("我会飞！");
  }
}
