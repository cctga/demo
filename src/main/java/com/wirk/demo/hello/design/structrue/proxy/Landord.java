package com.wirk.demo.hello.design.structrue.proxy;

/**
 * 房东
 * @author : Mao LuDong
 * @date : Created in 22:24 2019/12/3
 */
public class Landord implements Person {

  @Override
  public void rent() {
    System.out.println("我要出租！");
  }
}
