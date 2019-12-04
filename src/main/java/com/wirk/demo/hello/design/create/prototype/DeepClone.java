package com.wirk.demo.hello.design.create.prototype;

import com.wirk.demo.hello.design.create.builder.Computer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author : Mao LuDong
 * @date : Created in 13:05 2019/12/4
 */
public class DeepClone implements Serializable, Cloneable {

  private String name;
  private Computer computer;

  /**
   * 使用序列化方式深克隆对象，感觉和Clone实现的深克隆相比也一般般，也要实现一个空接口，也很烦啊大佬
   * @return DeepClone对象
   */
  @Override
  protected DeepClone clone() {
    try {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      new ObjectOutputStream(out).writeObject(this);
      ObjectInputStream objectInputStream =
          new ObjectInputStream(new ByteArrayInputStream(out.toByteArray()));
      return (DeepClone) objectInputStream.readObject();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public String toString() {
    return "DeepClone{" + "name='" + name + '\'' + ", computer=" + computer + '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Computer getComputer() {
    return computer;
  }

  public void setComputer(Computer computer) {
    this.computer = computer;
  }
}
