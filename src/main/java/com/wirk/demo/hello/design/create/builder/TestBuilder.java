package com.wirk.demo.hello.design.create.builder;

/**
 * @author : Mao LuDong
 * @date : Created in 9:50 2019/12/4
 */
public class TestBuilder {

  public static void main(String[] args) {
    Seller seller = new Seller(new MacBookProBuilder());
    Computer sell = seller.sell();
    System.out.println(sell);
  }
}
