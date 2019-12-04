package com.wirk.demo.hello.design.create.single;

/**
 * 利用枚举实现单例
 * 不过同饿汉类似，如果枚举类被初始化则对象生成
 * 不过优于饿汉式的是，不会被反射和反序列化影响
 *
 * @author : Mao LuDong
 * @date : Created in 20:10 2019/12/4
 */
enum EnumSingleton {
  /**
   * 单例对象
   */
  INSTANCE;

  public static EnumSingleton getInstance(){
    return INSTANCE;
  }

}
