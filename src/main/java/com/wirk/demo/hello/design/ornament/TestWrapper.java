package com.wirk.demo.hello.design.ornament;

/**
 * 测试装饰模式
 * @author : Mao LuDong
 * @date : Created in 21:12 2019/12/3
 */
public class TestWrapper {

  public static void main(String[] args) {
    Man man = new CommonWrapperPowerMan(new CommonWrapperFlyMan(new CommonMan()));
    man.action();
  }
}
