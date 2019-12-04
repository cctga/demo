package com.wirk.demo.hello.design.create.builder;

import java.io.Serializable;

/**
 * 建造模式使用的产品类，实现克隆接口为了在原型模式中使用
 * @author : Mao LuDong
 * @date : Created in 9:40 2019/12/4
 */
public class Computer implements Cloneable,Serializable{
  private String CPU;
  private String GPU;
  private String memory;
  private String hardDisk;

  public String getCPU() {
    return CPU;
  }

  public Computer setCPU(String CPU) {
    this.CPU = CPU;
    return this;
  }

  public String getGPU() {
    return GPU;
  }

  public Computer setGPU(String GPU) {
    this.GPU = GPU;
    return this;
  }

  public String getMemory() {
    return memory;
  }

  public Computer setMemory(String memory) {
    this.memory = memory;
    return this;
  }

  public String getHardDisk() {
    return hardDisk;
  }

  public Computer setHardDisk(String hardDisk) {
    this.hardDisk = hardDisk;
    return this;
  }

  @Override
  public String toString() {
    return "Computer{" +
               "CPU='" + CPU + '\'' +
               ", GPU='" + GPU + '\'' +
               ", memory='" + memory + '\'' +
               ", hardDisk='" + hardDisk + '\'' +
               '}';
  }

  @Override
  public Computer clone() throws CloneNotSupportedException {
    return (Computer) super.clone();
  }
}
