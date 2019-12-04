package com.wirk.demo.hello.design.create.single;

/**
 * 饿汉式单例
 * 缺点：
 * 类加载时就生成，可能始终没有使用到
 * 在无意访问的时候，就会触发类的加载，生成类内所有静态对象，始终不使用就是内存泄露了，
 * 比如只是想访问一下其中的静态变量
 * 优点：
 * 实现简单，并且还算安全（并不能防止反射和反序列化生成）
 *
 * @author : Mao LuDong
 * @date : Created in 19:45 2019/12/4
 */
public class HungrySingleton {

  private static int flag = 1;
  private static HungrySingleton hungrySingleton = new HungrySingleton();

  private HungrySingleton() {
  }

  public static HungrySingleton getInstance() {
    return hungrySingleton;
  }
}
