package com.wirk.demo.hello.design.proxy.staticProxy;

import com.wirk.demo.hello.design.proxy.Landord;
import com.wirk.demo.hello.design.proxy.Person;

/**
 * 静态代理
 * @author : Mao LuDong
 * @date : Created in 22:26 2019/12/3
 */
public class Agent implements Person {

  private Landord landord;

  public Agent(Landord landord) {
    this.landord = landord;
  }

  @Override
  public void rent() {
    System.out.println("谁要出租！");

    landord.rent();

    System.out.println("房子漏水，联系修理工！");
  }
}
