package com.wirk.demo.hello.design.structrue.adapter;

/**
 * 适配器
 * @author : Mao LuDong
 * @date : Created in 21:42 2019/12/3
 */
public class ComputerAdapter implements Computer {

  private Dominate dominate;

  public ComputerAdapter(Dominate dominate) {
    this.dominate = dominate;
  }

  @Override
  public void run() {
    dominate.cost();
  }
}
