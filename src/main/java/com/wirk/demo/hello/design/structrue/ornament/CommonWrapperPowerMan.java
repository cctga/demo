package com.wirk.demo.hello.design.structrue.ornament;

/**
 * 力量装饰器
 * @author : Mao LuDong
 * @date : Created in 21:07 2019/12/3
 */
public class CommonWrapperPowerMan extends CommonWrapperMan {

  public CommonWrapperPowerMan(Man man) {
    super(man);
  }

  @Override
  public void action() {
    super.action();
    power();
  }

  private void power() {
    System.out.println("我有无穷力量！");
  }
}
