package com.wirk.demo.hello.design.create.single;

import java.io.Serializable;

/**
 * 懒汉式单例
 *
 * @author : Mao LuDong
 * @date : Created in 19:52 2019/12/4
 */
public class LazySingleton implements Serializable {

  /**
   * volatile 关键词有两个作用：
   * 1. 内存可见性，线程的内存立刻同步到所有的线程内存中
   * 2. 禁止指令重排序优化
   * JDK必须是JDK5或更高版本，因为从JDK5才开始使用新的JSR-133内存模型规范，而在这个规范中才增强了volatile这个语义
   */
  private static volatile LazySingleton lazySingleton = null;

  /**
   * 防止反序列化创建多个对象，防止反序列化的话，不实现序列化接口不就好了嘛
   */
  private LazySingleton() {
    if (lazySingleton != null) {
      try {
        throw new Exception("只能有一个对象！");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }


  public static LazySingleton getInstance() {
    if (lazySingleton == null) {
      //双重锁检测，既防止方法同步锁导致性能下降，又解决多线程单例失效的问题
      synchronized (LazySingleton.class) {
        if (lazySingleton == null) {
          lazySingleton = new LazySingleton();
        }
      }
    }
    return lazySingleton;
  }


  /**
   * 如果要死不是的实现了序列化接口，那么加上这个方法就保证了反序列化还是返回的单例对象
   * 反序列化检测反序列化的对象中存不存在本方法，如果存在本方法，用本方法返回的对象替代反序列化获得的对象
   * 具体实现可以查看 ObjectInputStream.readObject() 源码
   *
   * @return 单列对象
   */
  private Object readResolve() {
    return lazySingleton;
  }


}
