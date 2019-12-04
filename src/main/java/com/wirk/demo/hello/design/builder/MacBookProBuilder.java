package com.wirk.demo.hello.design.builder;

/**
 * @author : Mao LuDong
 * @date : Created in 9:44 2019/12/4
 */
public class MacBookProBuilder extends ComputerBuilder {
  @Override
  MacBookProBuilder bindCPU() {
    comp.setCPU("i7-8700K");
    return this;
  }

  @Override
  MacBookProBuilder bindGPU() {
    comp.setGPU("2080-8g");
    return this;
  }

  @Override
  MacBookProBuilder bindMemory() {
    comp.setMemory("32G*2");
    return this;
  }

  @Override
  MacBookProBuilder bindHandDisk() {
    comp.setHardDisk("4T*3");
    return this;
  }
}
