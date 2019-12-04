package com.wirk.demo.hello.design.create.prototype;

import com.wirk.demo.hello.design.create.builder.Computer;
import com.wirk.demo.hello.design.create.builder.MacBookProBuilder;
import com.wirk.demo.hello.design.create.builder.Seller;

/**
 * 测试原型模式
 * @author : Mao LuDong
 * @date : Created in 11:27 2019/12/4
 */
public class TestPrototype {
  public static void main(String[] args) {
    DeepClone peopleClone = new DeepClone();
    peopleClone.setName("marauding");
    Computer comp = new Seller(new MacBookProBuilder()).sell();
    peopleClone.setComputer(comp);
    DeepClone clone = peopleClone.clone();
    System.out.println(clone);
    peopleClone.setName("xxxix");
    System.out.println(clone);
  }
}
