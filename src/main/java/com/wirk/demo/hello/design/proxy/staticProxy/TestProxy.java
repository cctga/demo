package com.wirk.demo.hello.design.proxy.staticProxy;

import com.wirk.demo.hello.design.proxy.Landord;
import com.wirk.demo.hello.design.proxy.Person;

/**
 * 测试代理类
 * @author : Mao LuDong
 * @date : Created in 22:28 2019/12/3
 */
public class TestProxy {

  public static void main(String[] args) {
    //测试静态代理
    Person person = new Agent(new Landord());
    person.rent();
  }
}
