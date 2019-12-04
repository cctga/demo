package com.wirk.demo.hello.design.structrue.adapter;

/**
 * 测试适配器模式
 * @author : Mao LuDong
 * @date : Created in 21:47 2019/12/3
 */
public class TestAdapter {
  public static void main(String[] args) {
    Computer computer = new ComputerAdapter(new Dominate());
    computer.run();
  }
}
