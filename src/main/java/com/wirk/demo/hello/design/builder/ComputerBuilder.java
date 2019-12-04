package com.wirk.demo.hello.design.builder;

/**
 * @author : Mao LuDong
 * @date : Created in 9:42 2019/12/4
 */
public abstract class ComputerBuilder {

  protected Computer comp = new Computer();

  abstract ComputerBuilder bindCPU();

  abstract ComputerBuilder bindGPU();

  abstract ComputerBuilder bindMemory();

  abstract ComputerBuilder bindHandDisk();

  protected Computer getComputer() {
    return comp;
  }
}
