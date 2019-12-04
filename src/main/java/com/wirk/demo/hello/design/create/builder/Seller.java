package com.wirk.demo.hello.design.create.builder;

/**
 * @author : Mao LuDong
 * @date : Created in 9:48 2019/12/4
 */
public class Seller {

  ComputerBuilder computerBuilder;

  public Seller(ComputerBuilder computerBuilder) {
    this.computerBuilder = computerBuilder;
  }

  public Computer sell(){
    return computerBuilder.bindCPU().bindGPU().bindHandDisk().bindMemory().getComputer();
  }
}
