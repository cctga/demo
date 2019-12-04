package com.wirk.demo.hello.design.create.single;

/**
 * 静态内部类实现单例 因为类的初始化只会导致本类的静态量初始化，而不会初始化静态内部类
 *
 * 比较完美的方案
 *
 * @author : Mao LuDong
 * @date : Created in 20:05 2019/12/4
 */
public class StaticInnerSingleton {

  private StaticInnerSingleton() {}

  public static StaticInnerSingleton getInstance() {
    return Inner.instance;
  }

  private static class Inner {
    private static StaticInnerSingleton instance = new StaticInnerSingleton();
  }
}
