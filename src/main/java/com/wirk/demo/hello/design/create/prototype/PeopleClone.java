package com.wirk.demo.hello.design.create.prototype;

import com.wirk.demo.hello.design.create.builder.Computer;

/**
 * 原型模式又称为克隆模式😄
 *
 * @author : Mao LuDong
 * @date : Created in 11:04 2019/12/4
 */
public class PeopleClone implements Cloneable {

  private String name;
  /** 浅克隆会导致该属性共同被修改 */
  private Computer computer;

  /**
   * 这种形式的深克隆会要求每一个嵌套都实现clone接口，比较麻烦，简单点的可以通过序列化和反序列来实现深克隆
   *
   * @return PeopleClone
   * @throws CloneNotSupportedException 不支持克隆，如果没有实现clone接口会被抛出
   */
  @Override
  protected PeopleClone clone() throws CloneNotSupportedException {
    return ((PeopleClone) super.clone()).setComputer(this.computer.clone());
  }

  public String getName() {
    return name;
  }

  public PeopleClone setName(String name) {
    this.name = name;
    return this;
  }

  public Computer getComputer() {
    return computer;
  }

  public PeopleClone setComputer(Computer computer) {
    this.computer = computer;
    return this;
  }

  @Override
  public String toString() {
    return "PeopleClone{" + "name='" + name + '\'' + ", computer=" + computer + '}';
  }
}
