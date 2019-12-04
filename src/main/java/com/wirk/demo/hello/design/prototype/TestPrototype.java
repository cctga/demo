package com.wirk.demo.hello.design.prototype;

import com.wirk.demo.hello.design.builder.Computer;
import com.wirk.demo.hello.design.builder.MacBookProBuilder;
import com.wirk.demo.hello.design.builder.Seller;

/**
 * @author : Mao LuDong
 * @date : Created in 11:27 2019/12/4
 */
public class TestPrototype {
  public static void main(String[] args) throws CloneNotSupportedException {
    PeopleClone peopleClone = new PeopleClone();
    peopleClone.setName("maoludong");
    Computer comp = new Seller(new MacBookProBuilder()).sell();
    peopleClone.setComputer(comp);
    PeopleClone clone = peopleClone.clone();
    System.out.println(clone);
  }
}
