package com.wirk.demo.hello.design.structrue.wrapper;

/**
 * 装饰器父类
 * @author : Mao LuDong
 * @date : Created in 21:07 2019/12/3
 */
public class CommonWrapperMan implements Man {
  private Man man;

  public CommonWrapperMan(Man man) {
    this.man = man;
  }

  @Override
  public void action(){
    man.action();
  }
}
